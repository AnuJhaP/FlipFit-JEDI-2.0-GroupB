package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.exceptions.RegisterationFailedForCustomerException;
import com.flipkart.exceptions.UserInvalidException;
import com.flipkart.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.flipkart.constant.SQLConstants.ADD_NEW_CUSTOMER;

public class CustomerDAO implements CustomerInterfaceDAO{
    @Override
    public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber) throws RegisterationFailedForCustomerException {
        try {
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(ADD_NEW_CUSTOMER);
            stmt.setString(1, userName);
            stmt.setString(2, userName);
            stmt.setString(3, password);
            stmt.setString(4, email);
            stmt.setString(5, phoneNumber);
            stmt.setString(6, cardNumber);

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException exp) {
            throw new RegisterationFailedForCustomerException("Failed to register the user. Try again.");
        } catch (Exception e) {
            System.out.println("Oops! An error occurred. Try again later.");
        }
    }

    @Override
    public boolean isUserValid(String userName, String password) throws UserInvalidException {
        return false;
    }

    @Override
    public FlipFitCustomer getCustomerById(String userName) {
        return null;
    }
}
