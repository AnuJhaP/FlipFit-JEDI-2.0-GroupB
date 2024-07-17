package com.flipkart.business;

import com.flipkart.bean.FlipFitBooking;

import java.util.Date;
import java.util.List;

public class BookingServiceImpl implements BookingService {
    @Override
    public boolean checkBookingOverlap(String customerId, Date data, String slotId) {
        return false;
    }

    @Override
    public void addBooking(String userId, String scheduleID) {

    }

    public void cancelBooking(String bookingID) {

    }

    public List<FlipFitBooking> getBookingByCustomerId(String customerId){

        return null;
    }
}
