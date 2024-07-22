package com.flipkart.business;
import com.flipkart.bean.FlipFitBooking;

import java.util.Date;
import java.util.List;
import com.flipkart.bean.FlipFitBooking;
import com.flipkart.utils.UserPlan;

import java.util.Date;
import java.util.List;

public interface BookingService{
    boolean checkBookingOverlap(String customerId, Date date, String slotId);
    void addBooking(String userId, String scheduleID);
    List<FlipFitBooking> getBookingByCustomerId(String customerId);
    void cancelBooking(String bookingID);
    List<UserPlan> getCustomerPlan(String customerId);
}