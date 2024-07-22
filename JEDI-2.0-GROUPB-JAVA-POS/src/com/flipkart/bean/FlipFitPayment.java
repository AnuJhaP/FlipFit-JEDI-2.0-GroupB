package com.flipkart.bean;

// FlipFitPayment class represents a payment entity in the FlipFit system
public class FlipFitPayment {
    private String paymentId;    // Unique identifier for the payment
    private String amountPaid;   // Amount paid for the payment
    private String bookingId;    // ID of the booking associated with the payment

    // Constructor for FlipFitPayment class (empty)
    public FlipFitPayment() {
        // Default constructor is empty
    }

    // Getter method for retrieving payment ID
    public String getPaymentId() {
        return paymentId;
    }

    // Setter method for updating payment ID
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    // Getter method for retrieving amount paid
    public String getAmountPaid() {
        return amountPaid;
    }

    // Setter method for updating amount paid
    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    // Getter method for retrieving booking ID associated with the payment
    public String getBookingId() {
        return bookingId;
    }

    // Setter method for updating booking ID associated with the payment
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    /*
    // Getter and setter methods for commented-out fields (if needed in future)
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }
    */
}