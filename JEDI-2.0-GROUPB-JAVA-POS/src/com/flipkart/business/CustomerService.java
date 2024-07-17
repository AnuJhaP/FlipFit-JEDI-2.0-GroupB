package com.flipkart.business;


import com.flipkart.bean.FlipFitBooking;
import com.flipkart.bean.PaymentType;

import java.util.List;
import java.sql.Date;

public interface CustomerService {
    boolean BookSlot(String userId,Date date,int SlotId,int centerId);
    boolean CancelSlot(String userId,Date date,int SlotId,int centerId);
    boolean makePayments(String paymentId, String paymentAmount, PaymentType paymentType);
    List<FlipFitBooking> showBookings(String userId);
}
