package com.flipkart.business;

import com.flipkart.bean.FlipFitBooking;
import com.flipkart.bean.FlipFitCustomer;

import java.sql.Date;
import java.util.List;
import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitSlot;
import com.flipkart.dao.CustomerDAO;
import com.flipkart.dao.CustomerInterfaceDAO;
import com.flipkart.exceptions.RegisterationFailedForCustomerException;
import com.flipkart.exceptions.UserInvalidException;
import com.flipkart.utils.UserPlan;

/**
 * @author JEDI-02
 * Service implementation for Customer Operations
 *
 */

public class CustomerServiceImpl implements CustomerService {

    private CustomerInterfaceDAO customerDAO = new CustomerDAO();
    private GymCenterServiceImpl gymCentreService = new GymCenterServiceImpl();
    private BookingServiceImpl bookingService = new BookingServiceImpl();
    private ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();

    private SlotServiceImpl slotService = new SlotServiceImpl();

    /**
     * Retrieves details of all gym centers in a specified city.
     *
     * @param city City name
     * @return List of gym centers in the specified city
     */
    public List<FlipFitCenter> getAllGymCenterDetailsByCity(String city){
        return gymCentreService.getCentresByCity(city);
    }

    /**
     * Retrieves available slots for booking at a specified gym center on a given date.
     *
     * @param centreID ID of the gym center
     * @param date     Date for which available slots are requested
     * @return List of available slots
     */
    public List<FlipFitSlot> getAvailableSlots(String centreID, Date date){
        return gymCentreService.getAvailableSlotsByCentreAndDate(centreID,date);
    }

    /**
     * Retrieves bookings made by a customer based on customer ID.
     *
     * @param customerId Customer ID
     * @return List of bookings made by the customer
     */
    public List<FlipFitBooking> getCustomerBookings(String customerId){
        return bookingService.getBookingByCustomerId(customerId);
    }

    /**
     * Retrieves customer plans based on customer ID.
     *
     * @param customerId Customer ID
     * @return List of plans associated with the customer
     */
    public List<UserPlan> getCustomerPlan(String customerId){
        return bookingService.getCustomerPlan(customerId);
    }

    /**
     * Books a slot for a customer at a specified gym center on a given date.
     *
     * @param userName Username of the customer
     * @param date     Date of the booking
     * @param slotId   Slot ID to book
     * @param centreId ID of the gym center
     * @return true if booking was successful, false otherwise
     */
    public boolean bookSlot(String userName,Date date, String slotId,String centreId){
        if(!slotService.isSlotValid(slotId,centreId)){
            System.out.println("INVALID_SLOT");
            return false;
        }
        String scheduleId = scheduleService.getOrCreateSchedule(slotId,date).getScheduleID();
        boolean isOverlap = bookingService.checkBookingOverlap(userName,date,slotId);
        if(isOverlap) {
            System.out.println("There exists a conflicting booking, First cancel it!!!!" );
            return false;
        }
        bookingService.addBooking(userName, scheduleId);
        return true;
    }

    /**
     * Cancels a booking based on booking ID.
     *
     * @param bookingID Booking ID to cancel
     */
    public void cancelBookingbyID(String bookingID){
        bookingService.cancelBooking(bookingID);
    }

    /**
     * Registers a new customer with the provided details.
     *
     * @param userName    Username of the new customer
     * @param password    Password of the new customer
     * @param email       Email of the new customer
     * @param phoneNumber Phone number of the new customer
     * @param cardNumber  Card number of the new customer
     */
    public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber) {
        try {
            customerDAO.registerCustomer(userName,password,email,phoneNumber,cardNumber);
        } catch (RegisterationFailedForCustomerException e) {
            e.getMessage();
        }

    }

    /**
     * Retrieves the profile details of a customer based on username.
     *
     * @param userName Username of the customer
     * @return Profile details of the customer
     */
    public FlipFitCustomer viewMyProfile(String userName) {
        return customerDAO.getCustomerById(userName);
    }

    /**
     * Checks if a user with the specified username and password exists and is valid.
     *
     * @param userName Username of the user
     * @param password Password of the user
     * @return true if user is valid, false otherwise
     */
    public boolean isUserValid(String userName, String password) {
        try {
            return customerDAO.isUserValid(userName,password);
        } catch (UserInvalidException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}