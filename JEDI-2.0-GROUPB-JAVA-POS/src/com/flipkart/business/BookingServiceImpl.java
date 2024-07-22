package com.flipkart.business;

import com.flipkart.bean.FlipFitBooking;

import java.util.Date;
import java.util.List;

import com.flipkart.dao.BookingDAO;
import com.flipkart.bean.FlipFitBooking;
import com.flipkart.bean.FlipFitSlot;
import com.flipkart.exceptions.BookingFailedException;
import com.flipkart.utils.UserPlan;

import java.awt.print.Book;
import java.util.Date;
import java.util.List;


public class BookingServiceImpl implements BookingService {

    private final BookingDAO bookingDAO = new BookingDAO();
    private final ScheduleService scheduleService  = new ScheduleServiceImpl();

    private final SlotService slotService = new SlotServiceImpl();

    public boolean checkBookingOverlap(String customerId, Date date, String slotId){
        FlipFitSlot slot = slotService.getSlotByID(slotId);
        return bookingDAO.checkBookingOverlap(customerId,date,slot.getTime());
    }
    public void addBooking(String userName, String scheduleID) {
        try {
            boolean isAvailable = scheduleService.modifySchedule(scheduleID,-1);
            if(!isAvailable){
                System.out.println("No seats available for the booking");
                return;
            }
            bookingDAO.addBooking(userName, scheduleID);
        } catch (BookingFailedException e) {
            System.out.println(e.getMessage());
        }

    }

    public List<FlipFitBooking> getBookingByCustomerId(String customerId){
        try {
            return bookingDAO.getBookingByCustomerId(customerId);
        } catch (BookingFailedException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    public List<UserPlan> getCustomerPlan(String customerId){
        return bookingDAO.getCustomerPlan(customerId);
    }

    public void cancelBooking(String bookingID) {
        try {
            FlipFitBooking booking  = bookingDAO.getBookingByBookingId(bookingID);
            bookingDAO.cancelBookingById(bookingID);
            scheduleService.modifySchedule(booking.getScheduleID(),1);
        } catch (BookingFailedException e) {
            System.out.println(e.getMessage());
        }

    }
}