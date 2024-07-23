package com.flipkart.exceptions;
/**
 * Exception thrown when a user is found to be invalid.
 * This exception indicates that the user does not meet required criteria or is not valid for some reason.
 */
public class UserInvalidException extends Exception {
    /**
     * Constructs a UserInvalidException with the specified error message.
     *
     * @param message The detail message explaining why the user is considered invalid.
     */
    public UserInvalidException(String message) {
        super(message);
    }
}
