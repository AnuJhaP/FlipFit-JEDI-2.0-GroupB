package com.flipkart.dao;

import com.flipkart.bean.FlipFitBooking;
import java.util.List;

// BookingInterfaceDAO interface defines methods for managing bookings in the Flipkart system
public interface BookingInterfaceDAO {

    // Method to add a booking for a customer identified by userName and scheduleID
    void addBooking(String userName, String scheduleID);

    // Method to retrieve bookings associated with a customer identified by customerId
    List<FlipFitBooking> getBookingByCustomerId(String customerId);

    // Method to cancel a booking identified by bookingID
    void cancelBookingById(String bookingID);
}
