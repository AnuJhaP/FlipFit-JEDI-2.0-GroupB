package com.flipkart.exceptions;
// Importing static constants from FlipFitConstant for coloring the output
import static com.flipkart.constant.FlipFitConstant.RED_COLOR;
import static com.flipkart.constant.FlipFitConstant.RESET_COLOR;

/**
 * Custom exception class to handle booking failures.
 * This class extends RuntimeException and allows for a custom error message.
 */
public class BookingFailedException extends RuntimeException{
    /**
     * Constructor for BookingFailedException.
     * It takes a message as a parameter, which is displayed in red color.
     *
     * @param message The error message to be displayed when the exception is thrown.
     */
    public BookingFailedException(String message){
        // Calling the constructor of the superclass (RuntimeException) with the colored message
        super(RED_COLOR+message+RESET_COLOR);
    }
}