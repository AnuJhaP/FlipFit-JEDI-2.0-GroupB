package com.flipkart.bean;

/**
 * FlipFitPayment class represents a payment entity in the FlipFit system.
 * It encapsulates information about a payment, including payment ID, amount paid, and associated booking ID.
 */
public class FlipFitPayment {
    private String paymentId;    // Unique identifier for the payment
    private String amountPaid;   // Amount paid for the payment
    private String bookingId;    // ID of the booking associated with the payment

    /**
     * Default constructor for creating a FlipFitPayment object.
     * Initializes the object with default values.
     */
    public FlipFitPayment() {
        // Default constructor is empty
    }

    /**
     * Getter method to retrieve the payment ID.
     *
     * @return The payment ID of the FlipFitPayment object.
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Setter method to update the payment ID.
     *
     * @param paymentId The new payment ID to be set for the FlipFitPayment object.
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * Getter method to retrieve the amount paid for the payment.
     *
     * @return The amount paid as a String for the FlipFitPayment object.
     */
    public String getAmountPaid() {
        return amountPaid;
    }

    /**
     * Setter method to update the amount paid for the payment.
     *
     * @param amountPaid The new amount paid as a String to be set for the FlipFitPayment object.
     */
    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    /**
     * Getter method to retrieve the booking ID associated with the payment.
     *
     * @return The booking ID associated with the payment for the FlipFitPayment object.
     */
    public String getBookingId() {
        return bookingId;
    }

    /**
     * Setter method to update the booking ID associated with the payment.
     *
     * @param bookingId The new booking ID to be set for the FlipFitPayment object.
     */
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