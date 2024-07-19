package com.flipkart.business;


import com.flipkart.bean.*;
import com.flipkart.utils.CustomerPlan;

import java.util.List;
import java.sql.Date;

public interface CustomerService {
    boolean bookSlot(String userId, Date date, String SlotId, String centerId);
    boolean CancelSlot(String userId,Date date,int SlotId,int centerId);
    boolean makePayments(String paymentId, String paymentAmount, PaymentType paymentType);
    List<FlipFitBooking> showBookings(String userId);
    List<CustomerPlan> getCustomerPlan(String userName);
    void registerCustomer(String userName, String password, String email, String phoneNumber);
    FlipFitCustomer viewMyProfile(String userName);
    void cancelBookingbyID(String bookingID);
    List<FlipFitCenter> getAllGymCenterDetailsByCity(String city);
    List<FlipFitBooking> getCustomerBookings(String customerId);
    List<FlipFitSlot> getAvailableSlots(String centreID, Date date);
}
