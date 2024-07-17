package com.flipkart.business;

import com.flipkart.bean.FlipFitBooking;
import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.PaymentType;

import java.sql.Date;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private BookingService bookingService = new BookingServiceImpl();
    @Override
    public boolean BookSlot(String userId, Date date, int SlotId, int centerId) {
        return false;
    }

    @Override
    public boolean CancelSlot(String userId, Date date, int SlotId, int centerId) {
        return false;
    }

    @Override
    public boolean makePayments(String paymentId, String paymentAmount, PaymentType paymentType) {
        return false;
    }

    @Override
    public List<FlipFitBooking> showBookings(String userId) {
        return List.of();
    }

    @Override
    public String registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber) {

        return null;
    }

    @Override
    public FlipFitCustomer viewMyProfile(String userId) {

        return null;
    }

    @Override
    public void cancelBookingbyID(String bookingID){
        //cancel a booking
        bookingService.cancelBooking(bookingID);
    }

    @Override
    public List<FlipFitBooking> getCustomerBookings(String customerId){
        //takes userId and returns List<Bookings>
        return bookingService.getBookingByCustomerId(customerId);
    }
}
