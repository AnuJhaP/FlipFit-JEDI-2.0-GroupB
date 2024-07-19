package com.flipkart.constant;

public class SQLConstants {
    /**
     * Customer SQL Queries
     */
    public static final String ADD_NEW_CUSTOMER = "INSERT INTO FlipFit.Customer (Id,name,password,email,phone,cardDetails) VALUES (?, ?, ?, ?, ?, ?);";
    public static final String CUSTOMER_LOGIN_QUERY = "SELECT * FROM FlipFit.Customer WHERE name = ? AND password = ?";
    public static final String GET_CUSTOMER_BY_ID = "SELECT * FROM FlipFit.Customer WHERE name = ?;";

}
