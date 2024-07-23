package com.flipkart.exceptions;

/**
 * Exception thrown when login fails due to incorrect username or password.
 * This exception indicates that the provided credentials were not valid.
 */
public class LoginFailedException extends RuntimeException{
    /**
     * Constructs a LoginFailedException with the specified error message.
     *
     * @param message The detail message explaining the reason for the login failure.
     */
    public LoginFailedException(String message){
        super(message);
        System.out.println("Unable to login, Check your username and password");
    }
}