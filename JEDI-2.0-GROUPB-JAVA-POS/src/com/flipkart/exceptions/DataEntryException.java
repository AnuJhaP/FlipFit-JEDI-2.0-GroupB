package com.flipkart.exceptions;
// Importing static constants from FlipFitConstant for coloring the output

import static com.flipkart.constant.FlipFitConstant.RED_COLOR;
import static com.flipkart.constant.FlipFitConstant.YELLOW_COLOR;

/**
 * Custom exception class to handle data entry errors.
 * This class extends RuntimeException and provides a custom error message.
 */

public class DataEntryException extends RuntimeException{
    /**
     * Constructor for DataEntryException.
     * It provides a default error message indicating an incorrect data format.
     */
    public DataEntryException(){
        // Calling the constructor of the superclass (RuntimeException) with a colored message
        // The message is in red to indicate an error and ends with yellow to highlight the need for format reference
        super(RED_COLOR+"Incorrect Data format. Please refer to the format."+YELLOW_COLOR);
    }
}