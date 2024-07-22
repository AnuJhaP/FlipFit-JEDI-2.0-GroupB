package com.flipkart.bean;

// FlipFitCustomer class represents a customer in the FlipFit system, extending FlipFitUser
public class FlipFitCustomer extends FlipFitUser {
    // Additional fields specific to FlipFitCustomer
    private String customerPhone;    // Phone number of the customer
    private String cardDetails;      // Card details of the customer (e.g., credit card information)

    // Constructor without parameters
    public FlipFitCustomer() {
        super(); // Call to superclass constructor (FlipFitUser)
    }

    // Constructor with parameters to initialize FlipFitCustomer object
    public FlipFitCustomer(String userId, String userName, String email, String password, String customerPhone, String cardDetails) {
        super(userId, userName, email, password, Role.CUSTOMER); // Call to superclass constructor (FlipFitUser) with specific role
        this.customerPhone = customerPhone;
        this.cardDetails = cardDetails;
    }

    // Getter method for retrieving customer's phone number
    public String getCustomerPhone() {
        return customerPhone;
    }

    // Setter method for updating customer's phone number
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    // Getter method for retrieving customer's card details
    public String getCardDetails() {
        return cardDetails;
    }

    // Setter method for updating customer's card details
    public void setCardDetails(String cardDetails) {
        this.cardDetails = cardDetails;
    }

    // Potential additional methods related to payments can be uncommented and implemented based on requirements
    /*
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
    */

    // Overriding toString method to provide a string representation of the FlipFitCustomer object
    @Override
    public String toString() {
        return "FlipFitCustomer{" +
                "userId='" + getUserId() + '\'' +
                ", userName='" + getUserName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", cardDetails='" + cardDetails + '\'' +
                '}';
    }
}
