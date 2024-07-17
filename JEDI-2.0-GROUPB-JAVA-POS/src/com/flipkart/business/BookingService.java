package com.flipkart.business;
import java.util.Date;

public interface BookingService {
    boolean checkBookingOverlap(String customerId, Date date, String slotId);
    void addBooking(String userId, String scheduleID);
    void cancelBooking(String bookingID);
}


