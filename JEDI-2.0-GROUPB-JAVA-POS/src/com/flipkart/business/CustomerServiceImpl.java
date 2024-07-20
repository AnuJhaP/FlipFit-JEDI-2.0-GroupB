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
public class CustomerServiceImpl implements CustomerService {

    private CustomerInterfaceDAO customerDAO = new CustomerDAO();
    private GymCenterServiceImpl gymCentreService = new GymCenterServiceImpl();
    private BookingServiceImpl bookingService = new BookingServiceImpl();
    private ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();

    private SlotServiceImpl slotService = new SlotServiceImpl();

    public List<FlipFitCenter> getAllGymCenterDetailsByCity(String city){
        return gymCentreService.getCentresByCity(city);
    }

    public List<FlipFitSlot> getAvailableSlots(String centreID, Date date){
        return gymCentreService.getAvailableSlotsByCenterAndDate(centreID,date);
    }

    public List<FlipFitBooking> getCustomerBookings(String customerId){
        return bookingService.getBookingByCustomerId(customerId);
    }

    public List<UserPlan> getCustomerPlan(String customerId){
        return bookingService.getCustomerPlan(customerId);
    }

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



    public void cancelBookingbyID(String bookingID){
        bookingService.cancelBooking(bookingID);
    }

    public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber) {
        try {
            customerDAO.registerCustomer(userName,password,email,phoneNumber,cardNumber);
        } catch (RegistrationFailedException | RegisterationFailedForCustomerException e) {
            e.getMessage();
        }

    }

    public FlipFitCustomer viewMyProfile(String userName) {
        return customerDAO.getCustomerById(userName);
    }

    public boolean isUserValid(String userName, String password) {
        try {
            return customerDAO.isUserValid(userName,password);
        } catch (UserInvalidException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}