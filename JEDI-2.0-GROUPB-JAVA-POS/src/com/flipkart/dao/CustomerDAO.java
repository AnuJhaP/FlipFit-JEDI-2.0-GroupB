package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.exceptions.RegisterationFailedForCustomerException;
import com.flipkart.exceptions.UserInvalidException;
import com.flipkart.utils.DBConnection;

import java.sql.*;

import static com.flipkart.constant.SQLConstants.*;

public class CustomerDAO implements CustomerInterfaceDAO{
    @Override
    public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber) throws RegisterationFailedForCustomerException {
        try {
//            Connection con = DBConnection.connect();
            Class.forName("com.mysql.jdbc.Driver");

            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema","root","Poojayadav5*");
//
//            PreparedStatement stmt = con.prepareStatement(ADD_NEW_USER);
//            stmt.setString(1, userName);
//            stmt.setString(2, userName);
//            stmt.setString(3, password);
//            stmt.setString(4, email);
//            try {
//                stmt.executeUpdate();
//            }
//            catch(Exception e){
//                System.out.println("Problem in User insert"+e.getMessage());
//            }
//            con.close();
            PreparedStatement stmt = con.prepareStatement(ADD_NEW_CUSTOMER);

            String x="id";
            stmt.setString(1, userName);
            stmt.setString(2, userName);
            stmt.setString(3, password);
            stmt.setString(4, email);
            stmt.setString(5, phoneNumber);
            stmt.setString(6, cardNumber);
//            stmt.setString(3, x);
            System.out.println("Inside");
            try {
                stmt.executeUpdate();
            }
            catch(Exception e){
                System.out.println("Problem in customer insert"+e.getMessage());
            }
            stmt.close();
        } catch (SQLException exp) {
            throw new RegisterationFailedForCustomerException("Failed to register the user. Try again.");
        } catch (Exception e) {
            System.out.println("Oops! An error occurred. Try again later.");
        }
    }

    @Override
    public boolean isUserValid(String userName, String password) throws UserInvalidException {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema","root","Poojayadav5*");
//
            PreparedStatement stmt = con.prepareStatement(CUSTOMER_LOGIN_QUERY);
            stmt.setString(1, userName);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                stmt.close();
                return true;
            }
            stmt.close();
        } catch (SQLException exp) {
            throw new UserInvalidException("User is Invalid. Try again.");
        } catch (Exception exp) {
            System.out.println("Oops! An error occurred. Try again later.");
        }
        return false;
    }

    @Override
    public FlipFitCustomer getCustomerById(String userName) {
        FlipFitCustomer customer = new FlipFitCustomer();
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema","root","Poojayadav5*");
//
            PreparedStatement stmt = con.prepareStatement(GET_CUSTOMER_BY_ID);
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            customer.setEmailId(rs.getString("email"));
            customer.setUserId(rs.getString("userId"));
            customer.setPassword(rs.getString("password"));
            customer.setUserName(rs.getString("userName"));
            customer.setCustomerPhone(rs.getString("customerPhone"));
            customer.setCardDetails(rs.getString("cardDetails"));

            stmt.close();
        } catch (SQLException exp) {
            exp.printStackTrace();
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        return customer;
    }
}
