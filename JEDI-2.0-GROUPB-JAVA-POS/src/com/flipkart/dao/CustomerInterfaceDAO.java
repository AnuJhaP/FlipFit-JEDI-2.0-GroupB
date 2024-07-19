package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.exceptions.RegisterationFailedForCustomerException;
import com.flipkart.exceptions.UserInvalidException;

public interface CustomerInterfaceDAO {
    public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber) throws RegisterationFailedForCustomerException;
    public boolean isUserValid(String userName, String password) throws UserInvalidException;
    FlipFitCustomer getCustomerById(String userName);

}
