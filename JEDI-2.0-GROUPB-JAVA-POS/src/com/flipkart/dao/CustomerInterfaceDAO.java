package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.exceptions.RegisterationFailedForCustomerException;
import com.flipkart.exceptions.UserInvalidException;

/**
 * CustomerInterfaceDAO interface defines methods for managing customer-related operations in the Flipkart system
 */
public interface CustomerInterfaceDAO {

    /**
     * Registers a new customer in the system.
     *
     * @param userName    Username of the customer
     * @param password    Password of the customer
     * @param email       Email address of the customer
     * @param phoneNumber Phone number of the customer
     * @param cardNumber  Card number of the customer
     * @throws RegisterationFailedForCustomerException if registration fails
     */
    public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber)
            throws RegisterationFailedForCustomerException;

    /**
     * Validates if a user with the given username and password exists in the system.
     *
     * @param userName Username of the customer
     * @param password Password of the customer
     * @return true if user is valid, false otherwise
     * @throws UserInvalidException if validation fails
     */
    public boolean isUserValid(String userName, String password) throws UserInvalidException;

    /**
     * Retrieves customer details based on the username.
     *
     * @param userName Username of the customer
     * @return FlipFitCustomer object containing customer details
     */
    public FlipFitCustomer getCustomerById(String userName);
}