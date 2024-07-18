package com.flipkart.business;
import com.flipkart.bean.FlipFitBooking;

import java.util.Date;
import java.util.List;
public interface BookingService {
boolean checkBookingOverlap(String customerId,Date data,String slotId);
void addBooking(String userId,String scheduleID);
void cancelBooking(String bookingId);
List<FlipFitBooking> getBookingByCustomerId(String customerId);
}
