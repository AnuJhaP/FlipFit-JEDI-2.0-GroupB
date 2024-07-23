package com.flipkart.exceptions;

import java.io.InvalidObjectException;

import static com.flipkart.constant.FlipFitConstant.RED_COLOR;
import static com.flipkart.constant.FlipFitConstant.RESET_COLOR;

/**
 * Exception thrown when an invalid choice is encountered.
 * This typically occurs when user input does not match expected options.
 */
public class InvalidChoiceException extends InvalidObjectException {
    /**
     * Constructs an InvalidChoiceException with a predefined error message.
     * The message indicates that the user should enter a valid choice.
     */
    public InvalidChoiceException(){
        super(RED_COLOR+"Please enter valid choice"+RESET_COLOR);
    }
}