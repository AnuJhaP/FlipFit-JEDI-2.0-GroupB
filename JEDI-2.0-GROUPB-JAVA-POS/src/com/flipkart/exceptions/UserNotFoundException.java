package com.flipkart.exceptions;

import static com.flipkart.constant.FlipFitConstant.RED_COLOR;
import static com.flipkart.constant.FlipFitConstant.RESET_COLOR;

/**
 * Exception thrown when a user is not found.
 * This exception indicates that a requested user could not be found in the system.
 */
public class UserNotFoundException extends Exception {
    /**
     * Constructs a UserNotFoundException with the specified error message.
     *
     * @param message The detail message explaining why the user was not found.
     */
    public UserNotFoundException(String message){
        super(message);
        System.out.println(RED_COLOR+"User not found!!"+RESET_COLOR);
    }
}