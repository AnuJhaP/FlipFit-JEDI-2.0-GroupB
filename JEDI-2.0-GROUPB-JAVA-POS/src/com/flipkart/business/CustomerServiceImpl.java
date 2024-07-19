package com.flipkart.business;

import com.flipkart.bean.*;

import java.sql.Date;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private BookingService bookingService = new BookingServiceImpl();
    private SlotServiceImpl slotService = new SlotServiceImpl();
    private ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();
    private GymCenterServiceImpl gymCenterService = new GymCenterServiceImpl();


    public boolean bookSlot(String userId, Date date, String slotId, String centerId) {
        if(!slotService.isSlotValid(slotId,centerId)){
            System.out.println("invalid slot");
            return false;
        }
        String scheduleId = scheduleService.getOrCreateSchedule(slotId,date).getScheduleID();
        //create booking
        boolean isOverlap = bookingService.checkBookingOverlap(userId,date,slotId);
        if(isOverlap) {
            System.out.println("There exists a conflicting booking, First cancel it!!!!");
            return false;
        }
        bookingService.addBooking(userId, scheduleId);
        return true;
    }
    public List<FlipFitCenter> getAllGymCenterDetailsByCity(String city){
        //takes City (Location) as input and returns List<GymCenter>
        return gymCenterService.getCentresByCity(city);
    }



    public void CancelSlot(String bookingID) {
        bookingService.cancelBooking(bookingID);
    }

    @Override
    public boolean makePayments(String paymentId, String paymentAmount, PaymentType paymentType) {
        return false;
    }

    @Override
    public List<FlipFitBooking> showBookings(String userId) {
        return bookingService.getBookingByCustomerId(userId);
    }

    @Override
    public void registerCustomer(String userName, String password, String email, String phoneNumber) {
        customerDAO.registerCustomer(userName,password,email,phoneNumber);


    }

    @Override
    public FlipFitCustomer viewMyProfile(String userId) {
        return customerDAO.getCustomerById(userId);

    }

    @Override
    public void cancelBookingbyID(String bookingID){
        //cancel a booking
        bookingService.cancelBooking(bookingID);
    }

    @Override
    public List<FlipFitBooking> getCustomerBookings(String customerId){
        //takes userId and returns List<Bookings>
        return bookingService.getBookingByCustomerId(customerId);
    }
    public List<FlipFitSlot> getAvailableSlotsByCentreAndDate(String centreID, Date date){
        return scheduleService.getAllAvailableSlotsByDate(centreID, date);
    }
}
