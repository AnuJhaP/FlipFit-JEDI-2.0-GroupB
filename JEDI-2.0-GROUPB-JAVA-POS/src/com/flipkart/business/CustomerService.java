package com.flipkart.business;


import com.flipkart.bean.*;
import com.flipkart.utils.UserPlan;

import java.util.List;
import java.sql.Date;

public interface CustomerService {
        List<FlipFitCenter> getAllGymCenterDetailsByCity(String city);
        List<FlipFitSlot> getAvailableSlots(String centreID, Date date);
        List<FlipFitBooking> getCustomerBookings(String customerId);
        boolean bookSlot(String userID,Date date, String slotId,String centreId);
        void cancelBookingbyID(String bookingID);
        void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber);
        FlipFitCustomer viewMyProfile(String userName);
        boolean isUserValid(String userName, String password);

        List<UserPlan> getCustomerPlan(String userName);
    }
