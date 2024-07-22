package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.exceptions.RegisterationFailedForCustomerException;
import com.flipkart.exceptions.UserInvalidException;

// CustomerInterfaceDAO interface defines methods for managing customer-related operations in the Flipkart system
public interface CustomerInterfaceDAO {

    // Method to register a new customer with the specified details
    // Throws RegisterationFailedForCustomerException if registration fails
    public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber)
            throws RegisterationFailedForCustomerException;

    // Method to check if a user with the given username and password is valid
    // Returns true if the user is valid, otherwise throws UserInvalidException
    public boolean isUserValid(String userName, String password) throws UserInvalidException;

    // Method to retrieve a customer object by their username
    public FlipFitCustomer getCustomerById(String userName);
}
