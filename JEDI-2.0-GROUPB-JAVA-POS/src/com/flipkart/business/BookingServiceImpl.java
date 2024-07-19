package com.flipkart.business;

import com.flipkart.bean.FlipFitBooking;
import com.flipkart.bean.FlipFitSlot;
import com.flipkart.utils.CustomerPlan;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


//public class BookingServiceImpl implements BookingService {
//    private final ScheduleServiceImpl scheduleService  = new ScheduleServiceImpl();
//
//    private final SlotServiceImpl slotService = new SlotServiceImpl();
//
//    public boolean checkBookingOverlap(String customerId, Date date, String slotId){
//        //return whether the customer has already booked a slot at same timing
//        FlipFitSlot slot = slotService.getSlotByID(slotId);
//        return bookingDAO.checkBookingOverlap(customerId,date,slot.getStartTime());
//    }
//    public void addBooking(String userName, String scheduleID) {
//
//            boolean isAvailable = scheduleService.modifySchedule(scheduleID,-1);
//            if(!isAvailable){
//                System.out.println("No seats available for the booking");
//                return;
//            }
//            bookingDAO.addBooking(userName, scheduleID);
//        }
//
//
//
//    public List<FlipFitBooking> getBookingByCustomerId(String customerId){
//
//            return bookingDAO.getBookingByCustomerId(customerId);
//
//
//    }
//
//    public List<CustomerPlan> getCustomerPlan(String customerId){
//        return bookingDAO.getCustomerPlan(customerId);
//    }
//
//    public void cancelBooking(String bookingID) {
//
//            FlipFitBooking booking  = bookingDAO.getBookingByBookingId(bookingID);
//            bookingDAO.cancelBookingById(bookingID);
//            scheduleService.modifySchedule(booking.getScheduleID(),1);
//
//
//    }
public class BookingServiceImpl implements BookingService {
    private final ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();

    private List<FlipFitBooking> bookingList = new ArrayList<>();

    public boolean checkBookingOverlap(String customerId, Date date, String slotId) {
        for (FlipFitBooking booking : bookingList) {
            if (booking.getUserId().equals(customerId) && booking.getSlotId().equals(slotId)) {
                return true;
            }
        }
        return false;
    }

    public void addBooking(String userName, String scheduleID) {
        FlipFitBooking booking = new FlipFitBooking(userName, scheduleID);
        bookingList.add(booking);
    }

    public List<FlipFitBooking> getBookingByCustomerId(String customerId) {
        List<FlipFitBooking> customerBookings = new ArrayList<>();
        for (FlipFitBooking booking : bookingList) {
            if (booking.getUserId().equals(customerId)) {
                customerBookings.add(booking);
            }
        }
        return customerBookings;
    }

    public void cancelBooking(String bookingID) {
        for (Iterator<FlipFitBooking> iterator = bookingList.iterator(); iterator.hasNext(); ) {
            FlipFitBooking booking = iterator.next();
            if (booking.getBookingId().equals(bookingID)) {
                iterator.remove();
                break;
            }
        }
    }

}
