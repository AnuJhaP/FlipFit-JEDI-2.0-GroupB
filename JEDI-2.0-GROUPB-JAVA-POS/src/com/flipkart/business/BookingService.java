package com.flipkart.business;
import com.flipkart.bean.FlipFitBooking;

import java.util.Date;
import java.util.List;
import com.flipkart.bean.FlipFitBooking;
import com.flipkart.utils.UserPlan;

import java.util.Date;
import java.util.List;

/**
 * @author JEDI-02
 * Interface for Booking Service Operations
 *
 */

public interface BookingService{

    /**
     * Checks if there is a booking overlap for a customer on a specific date and slot.
     *
     * @param customerId Customer ID
     * @param date       Date of the booking
     * @param slotId     Slot ID
     * @return true if there is a booking overlap, false otherwise
     */
    boolean checkBookingOverlap(String customerId, Date date, String slotId);

    /**
     * Adds a booking for a customer with the specified schedule ID.
     *
     * @param userId     User ID of the customer
     * @param scheduleID Schedule ID for the booking
     */
    void addBooking(String userId, String scheduleID);

    /**
     * Retrieves bookings made by a customer based on customer ID.
     *
     * @param customerId Customer ID
     * @return List of bookings made by the customer
     */
    List<FlipFitBooking> getBookingByCustomerId(String customerId);

    /**
     * Cancels a booking based on booking ID.
     *
     * @param bookingID Booking ID to cancel
     */
    void cancelBooking(String bookingID);

    /**
     * Retrieves customer plans based on customer ID.
     *
     * @param customerId Customer ID
     * @return List of plans associated with the customer
     */
    List<UserPlan> getCustomerPlan(String customerId);
}