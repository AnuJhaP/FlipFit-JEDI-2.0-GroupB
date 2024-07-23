package com.flipkart.bean;

/**
 * FlipFitCustomer class represents a customer entity in the FlipFit system,
 * extending FlipFitUser for user-related functionalities.
 */
public class FlipFitCustomer extends FlipFitUser {
    private String customerPhone;    // Phone number of the customer
    private String cardDetails;      // Card details of the customer (e.g., credit card information)

    /**
     * Default constructor for creating a FlipFitCustomer object.
     * Calls the superclass constructor (FlipFitUser) with default parameters.
     */
    public FlipFitCustomer() {
        super(); // Call to superclass constructor (FlipFitUser)
    }

    /**
     * Constructor to initialize a FlipFitCustomer object with specified details.
     *
     * @param userId        The ID of the customer.
     * @param userName      The name of the customer.
     * @param email         The email address of the customer.
     * @param password      The password of the customer.
     * @param customerPhone The phone number of the customer.
     * @param cardDetails   The card details of the customer.
     */
    public FlipFitCustomer(String userId, String userName, String email, String password, String customerPhone, String cardDetails) {
        super(userId, userName, email, password, Role.CUSTOMER); // Call to superclass constructor (FlipFitUser) with specific role
        this.customerPhone = customerPhone;
        this.cardDetails = cardDetails;
    }

    /**
     * Getter method to retrieve the phone number of the customer.
     *
     * @return The phone number of the customer.
     */
    public String getCustomerPhone() {
        return customerPhone;
    }

    /**
     * Setter method to update the phone number of the customer.
     *
     * @param customerPhone The new phone number of the customer to be set.
     */
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    /**
     * Getter method to retrieve the card details of the customer.
     *
     * @return The card details of the customer.
     */
    public String getCardDetails() {
        return cardDetails;
    }

    /**
     * Setter method to update the card details of the customer.
     *
     * @param cardDetails The new card details of the customer to be set.
     */
    public void setCardDetails(String cardDetails) {
        this.cardDetails = cardDetails;
    }

    /**
     * Override toString method to provide a string representation of the FlipFitCustomer object.
     *
     * @return A string representation of the FlipFitCustomer object.
     */
    @Override
    public String toString() {
        return "FlipFitCustomer{" +
                "userId='" + getUserId() + '\'' +
                ", userName='" + getUserName() + '\'' +
                ", email='" + getEmailId() + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", cardDetails='" + cardDetails + '\'' +
                '}';
    }
}