package com.flipkart.exceptions;

import static com.flipkart.constant.FlipFitConstant.RED_COLOR;
import static com.flipkart.constant.FlipFitConstant.RESET_COLOR;

/**
 * Exception thrown when incorrect username or password credentials are provided.
 */
public class WrongCredentialsException extends Exception {

    /**
     * Constructs a new WrongCredentialsException with a default error message.
     */
    public WrongCredentialsException() {
        super(RED_COLOR+"Wrong username or password!"+RESET_COLOR);
    }
}