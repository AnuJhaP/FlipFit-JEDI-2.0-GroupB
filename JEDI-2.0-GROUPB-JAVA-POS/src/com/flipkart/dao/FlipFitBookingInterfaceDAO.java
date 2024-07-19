package com.flipkart.dao;

import com.flipkart.bean.FlipFitBooking;

import java.util.List;

public interface FlipFitBookingInterfaceDAO {

    void  addBooking(String userName, String scheduleID);
    List<FlipFitBooking> getBookingByCustomerId(String customerId);
    void cancelBookingById(String bookingID);

}
