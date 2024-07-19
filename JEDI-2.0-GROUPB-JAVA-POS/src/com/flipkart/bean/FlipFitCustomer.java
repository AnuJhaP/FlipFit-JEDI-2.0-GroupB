package com.flipkart.bean;

public class FlipFitCustomer extends FlipFitUser {
//    private String paymentId;
//    private String paymentAmount;
//    private PaymentType paymentType;

    private String customerPhone;
    private String cardDetails;

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(String cardDetails) {
        this.cardDetails = cardDetails;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    public FlipFitCustomer() {
        super();
    }
    public FlipFitCustomer(String userId, String userName, String email, String password, String customerPhone, String cardDetails) {
        super(userId, userName, email, password, Role.CUSTOMER);
        this.customerPhone = customerPhone;
        this.cardDetails = cardDetails;
    }


//    public void setPaymentId(String paymentId) {
//        this.paymentId = paymentId;
//    }
//
//    public PaymentType getPaymentType() {
//        return paymentType;
//    }
//
//    public void setPaymentType(PaymentType paymentType) {
//        this.paymentType = paymentType;
//    }
//
//    public String getPaymentAmount() {
//        return paymentAmount;
//    }
//
//    public void setPaymentAmount(String paymentAmount) {
//        this.paymentAmount = paymentAmount;
//    }
}
