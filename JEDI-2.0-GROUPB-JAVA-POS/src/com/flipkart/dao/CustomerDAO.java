package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.exceptions.RegisterationFailedForCustomerException;
import com.flipkart.exceptions.UserInvalidException;

import java.sql.*;

import static com.flipkart.constant.SQLConstants.*;

/**
 * DAO class implementing CustomerInterfaceDAO for handling customer-related operations in the Flipkart system.
 */
public class CustomerDAO implements CustomerInterfaceDAO {

    /**
     * Registers a new customer in the database.
     *
     * @param userName    Username of the customer
     * @param password    Password of the customer
     * @param email       Email of the customer
     * @param phoneNumber Phone number of the customer
     * @param cardNumber  Card number of the customer
     * @throws RegisterationFailedForCustomerException if registration fails
     */
    @Override
    public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber) throws RegisterationFailedForCustomerException {
        try {
            // Establish database connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema", "root", "ahdul0Uw!@#%");

            // Prepare SQL statement for adding a new customer
            PreparedStatement stmt = con.prepareStatement(ADD_NEW_CUSTOMER);
            stmt.setString(1, userName);
            stmt.setString(2, userName);   // Assuming this is for some identifier
            stmt.setString(3, password);
            stmt.setString(4, email);
            stmt.setString(5, phoneNumber);
            stmt.setString(6, cardNumber);

            // Execute the SQL statement
            stmt.executeUpdate();

            // Close the statement and connection
            stmt.close();
            con.close();
        } catch (SQLException exp) {
            throw new RegisterationFailedForCustomerException("Failed to register the user. Try again.");
        } catch (Exception e) {
            System.out.println("Oops! An error occurred. Try again later.");
        }
    }

    /**
     * Validates if a user with given credentials exists in the database.
     *
     * @param userName Username of the customer
     * @param password Password of the customer
     * @return true if user is valid, false otherwise
     * @throws UserInvalidException if validation fails
     */
    @Override
    public boolean isUserValid(String userName, String password) throws UserInvalidException {
        try {
            // Establish database connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema", "root", "ahdul0Uw!@#%");

            // Prepare SQL statement for customer login validation
            PreparedStatement stmt = con.prepareStatement(CUSTOMER_LOGIN_QUERY);
            stmt.setString(1, userName);
            stmt.setString(2, password);

            // Execute the query and retrieve results
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // User found, close statement and return true
                stmt.close();
                return true;
            }
            // User not found, close statement
            stmt.close();
        } catch (SQLException exp) {
            throw new UserInvalidException("User is Invalid. Try again.");
        } catch (Exception exp) {
            System.out.println("Oops! An error occurred. Try again later.");
        }
        return false;
    }

    /**
     * Retrieves customer details based on the username.
     *
     * @param userName Username of the customer
     * @return FlipFitCustomer object containing customer details
     */
    @Override
    public FlipFitCustomer getCustomerById(String userName) {
        FlipFitCustomer customer = new FlipFitCustomer();
        try {
            // Establish database connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema", "root", "ahdul0Uw!@#%");

            // Prepare SQL statement to retrieve customer by ID
            PreparedStatement stmt = con.prepareStatement(GET_CUSTOMER_BY_ID);
            stmt.setString(1, userName);

            // Execute query and retrieve results
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Set customer details from ResultSet
                customer.setEmailId(rs.getString("email"));
                customer.setUserId(rs.getString("userId"));
                customer.setPassword(rs.getString("password"));
                customer.setUserName(rs.getString("userName"));
                customer.setCustomerPhone(rs.getString("customerPhone"));
                customer.setCardDetails(rs.getString("cardDetails"));
            }
            // Close statement
            stmt.close();
        } catch (SQLException exp) {
            exp.printStackTrace();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return customer;
    }
}
