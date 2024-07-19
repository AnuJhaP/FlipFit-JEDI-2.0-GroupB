package com.flipkart.bean;

public class FlipFitCustomer extends FlipFitUser {
    private String paymentId;
    private String paymentAmount;
    private PaymentType paymentType;

    public FlipFitCustomer(String id, String userName, String email, String password, Role role) {
        super(id, userName, email, password, role);
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
