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

/**
 *
 * author JEDI-02
 * Implementation of Booking Operations.
 *
 */

public class BookingServiceImpl implements BookingService {

    private final BookingDAO bookingDAO = new BookingDAO();
    private final ScheduleService scheduleService  = new ScheduleServiceImpl();

    private final SlotService slotService = new SlotServiceImpl();

    /**
     * Checks if a booking overlaps with existing bookings.
     *
     * @param customerId Customer ID
     * @param date       Date of the booking
     * @param slotId     Slot ID
     * @return true if booking overlaps with existing bookings, false otherwise
     */
    public boolean checkBookingOverlap(String customerId, Date date, String slotId){
        FlipFitSlot slot = slotService.getSlotByID(slotId);
        return bookingDAO.checkBookingOverlap(customerId,date,slot.getTime());
    }

    /**
     * Adds a booking for a customer with the specified schedule ID.
     *
     * @param userName   Username of the customer
     * @param scheduleID Schedule ID for the booking
     */
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

    /**
     * Retrieves bookings made by a customer based on customer ID.
     *
     * @param customerId Customer ID
     * @return List of bookings made by the customer
     */
    public List<FlipFitBooking> getBookingByCustomerId(String customerId){
        try {
            return bookingDAO.getBookingByCustomerId(customerId);
        } catch (BookingFailedException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    /**
     * Retrieves customer plans based on customer ID.
     *
     * @param customerId Customer ID
     * @return List of plans associated with the customer
     */
    public List<UserPlan> getCustomerPlan(String customerId){
        return bookingDAO.getCustomerPlan(customerId);
    }

    /**
     * Cancels a booking based on booking ID.
     *
     * @param bookingID Booking ID to cancel
     */
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