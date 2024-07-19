package com.flipkart.bean;

public class FlipFitPayment {
//    private int userID;
//    // 1 -> UPI / 2 -> Debit Card
//    private int paymentType;
//    private String paymentInfo;
//    public String getPaymentInfo() {
//        return paymentInfo;
//    }
//
//    public void setPaymentInfo(String paymentInfo) {
//        this.paymentInfo = paymentInfo;
//    }
//
//    public int getPaymentType() {
//        return paymentType;
//    }
//
//    public void setPaymentType(int paymentType) {
//        this.paymentType = paymentType;
//    }
//
//
//    public int getUserID() {
//        return userID;
//    }
//
//    public void setUserID(int userID) {
//        this.userID = userID;
//    }


    private String paymentId;
    private String amountPaid;
    private String bookingId;

    public String getPaymentId() { return paymentId; }

    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }

    public String getAmountPaid() { return amountPaid; }

    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getBookingId() { return bookingId; }

    public void setBookingId(String bookingId) { this.bookingId = bookingId;}

}
