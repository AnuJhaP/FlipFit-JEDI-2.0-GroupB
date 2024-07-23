package com.flipkart.dao;

import com.flipkart.bean.FlipFitBooking;
import java.util.List;

/**
 * BookingInterfaceDAO interface defines methods for managing bookings in the Flipkart system
 */
public interface BookingInterfaceDAO {

    /**
     * Method to add a booking for a customer identified by userName and scheduleID.
     *
     * @param userName   Username of the customer making the booking
     * @param scheduleID ID of the schedule being booked
     */
    void addBooking(String userName, String scheduleID);

    /**
     * Method to retrieve bookings associated with a customer identified by customerId.
     *
     * @param customerId ID of the customer whose bookings are to be retrieved
     * @return List of FlipFitBooking objects representing the bookings
     */
    List<FlipFitBooking> getBookingByCustomerId(String customerId);

    /**
     * Method to cancel a booking identified by bookingID.
     *
     * @param bookingID ID of the booking to be cancelled
     */
    void cancelBookingById(String bookingID);
}
