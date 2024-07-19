package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.utils.CustomerPlan;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

//public class CustomerServiceImpl implements CustomerService {
//
//    private BookingService bookingService = new BookingServiceImpl();
//    private SlotServiceImpl slotService = new SlotServiceImpl();
//    private ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();
//    private GymCenterServiceImpl gymCenterService = new GymCenterServiceImpl();
//    static ArrayList<FlipFitCustomer> registeredCustomers=new ArrayList<>();
//    List<FlipFitBooking> bookings = new ArrayList<>();
//    List<FlipFitCenter> gyms = new ArrayList<>();
//
//    public boolean bookSlot(String userId, Date date, String slotId, String centerId) {
//        if(!slotService.isSlotValid(slotId,centerId)){
//            System.out.println("invalid slot");
//            return false;
//        }
//        String scheduleId = scheduleService.getOrCreateSchedule(slotId,date).getScheduleID();
//        //create booking
//        boolean isOverlap = bookingService.checkBookingOverlap(userId,date,slotId);
//        if(isOverlap) {
//            System.out.println("There exists a conflicting booking, First cancel it!!!!");
//            return false;
//        }
//        bookingService.addBooking(userId, scheduleId);
//        return true;
//    }
//    public List<FlipFitCenter> getAllGymCenterDetailsByCity(String city){
//        //takes City (Location) as input and returns List<GymCenter>
//        return gymCenterService.getCentresByCity(city);
//    }
//
//
//
//    public void CancelSlot(String bookingID) {
//        bookingService.cancelBooking(bookingID);
//    }
//
//    @Override
//    public boolean makePayments(String paymentId, String paymentAmount, PaymentType paymentType) {
//        return false;
//    }
//
//    @Override
//    public List<FlipFitBooking> showBookings(String userId) {
//        return bookingService.getBookingByCustomerId(userId);
//    }
//
//    @Override
//    public void registerCustomer(String userName, String password, String email, String phoneNumber) {
//        FlipFitCustomer customer=new FlipFitCustomer();
//        customer.setUserName(userName);
//        customer.setPassword(password);
//        customer.setEmailId(email);
//
//        if(registeredCustomers.isEmpty()||!registeredCustomers.contains(customer)) {
//            registeredCustomers.add(customer);
//
//        }
//
//
//    }
//
//    @Override
//    public FlipFitCustomer viewMyProfile(String userId) {
//        return customerDAO.getCustomerById(userId);
//
//    }
//
//    @Override
////    public void cancelBookingbyID(String bookingID){
//        bookingService.cancelBooking(bookingID);
//    }
//
//    @Override
//    public List<FlipFitBooking> getCustomerBookings(String customerId){
//        //takes userId and returns List<Bookings>
//        return bookingService.getBookingByCustomerId(customerId);
//    }
//    public List<FlipFitSlot> getAvailableSlotsByCentreAndDate(String centreID, Date date){
//        return scheduleService.getAllAvailableSlotsByDate(centreID, date);
//    }
//}
public class CustomerServiceImpl implements CustomerService {

    private BookingService bookingService = new BookingServiceImpl();
    private ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();
    private GymCenterServiceImpl gymCenterService = new GymCenterServiceImpl();

    static ArrayList<FlipFitCustomer> registeredCustomers = new ArrayList<>();
    List<FlipFitBooking> bookings = new ArrayList<>();
    List<FlipFitCenter> gyms = new ArrayList<>();

    public boolean bookSlot(String userId, Date date, String slotId, String centerId) {
        SlotServiceImpl slotService = new SlotServiceImpl();
        if (!slotService.isSlotValid(slotId, centerId)) {
            System.out.println("Invalid slot");
            return false;
        }
        String scheduleId = scheduleService.getOrCreateSchedule(slotId, date).getScheduleID();
        boolean isOverlap = bookingService.checkBookingOverlap(userId, date, slotId);
        if (isOverlap) {
            System.out.println("There is a conflicting booking; cancel it first!!!!");
            return false;
        }
        bookingService.addBooking(userId, scheduleId);
        return true;
    }

    @Override
    public boolean CancelSlot(String userId, Date date, int SlotId, int centerId) {
        return false;
    }

    public List<FlipFitCenter> getAllGymCenterDetailsByCity(String city) {
        return gymCenterService.getCentresByCity(city);
    }

    public void cancelSlot(String bookingID) {
        bookingService.cancelBooking(bookingID);
    }

    @Override
    public boolean makePayments(String paymentId, String paymentAmount, PaymentType paymentType) {

        return true; // Payment successful
    }

    @Override
    public List<FlipFitBooking> showBookings(String userId) {
        return bookingService.getBookingByCustomerId(userId);
    }

    @Override
    public List<CustomerPlan> getCustomerPlan(String userName) {
        return List.of();
    }

    @Override
    public void registerCustomer(String userName, String password, String email, String phoneNumber) {
        FlipFitCustomer customer = new FlipFitCustomer(userName+"_Hi" ,userName,password,email,new Role("abs","CUSTOMER"));
        customer.setUserName(userName);
        customer.setPassword(password);
        customer.setEmailId(email);

        if (registeredCustomers.isEmpty() || !registeredCustomers.contains(customer)) {
            registeredCustomers.add(customer);
        }
    }

    @Override
    public FlipFitCustomer viewMyProfile(String userId) {

        return null;
    }

    @Override
    public void cancelBookingbyID(String bookingID) {

    }

    public void cancelBookingByID(String bookingID) {
        bookingService.cancelBooking(bookingID);
    }

    @Override
    public List<FlipFitBooking> getCustomerBookings(String customerId) {
        return bookingService.getBookingByCustomerId(customerId);
    }

    @Override
    public List<FlipFitSlot> getAvailableSlots(String centreID, Date date) {
        return List.of();
    }

    public List<FlipFitSlot> getAvailableSlotsByCentreAndDate(String centreID, Date date) {
        return scheduleService.getAllAvailableSlotsByDate(centreID, date);
    }
}

