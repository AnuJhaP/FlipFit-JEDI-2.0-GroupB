package com.flipkart.dao;

import com.flipkart.bean.FlipFitBooking;
import java.util.List;

/**
 *  FlipFitBookingInterfaceDAO interface defines methods for managing bookings in the Flipkart system
 */
public interface FlipFitBookingInterfaceDAO {

    /**
     * Adds a booking for a customer into the system.
     *
     * @param userName   Username of the customer making the booking
     * @param scheduleID ID of the schedule being booked
     */
    void addBooking(String userName, String scheduleID);

    /**
     * Retrieves all bookings made by a customer identified by their customerId.
     *
     * @param customerId ID of the customer whose bookings are to be retrieved
     * @return List of FlipFitBooking objects representing the bookings
     */
    List<FlipFitBooking> getBookingByCustomerId(String customerId);

    /**
     * Cancels a booking identified by its bookingID.
     *
     * @param bookingID ID of the booking to be cancelled
     */
    void cancelBookingById(String bookingID);
}
