package com.flipkart.exceptions;
// Importing static constants from FlipFitConstant for coloring the output
import static com.flipkart.constant.FlipFitConstant.RED_COLOR;
import static com.flipkart.constant.FlipFitConstant.RESET_COLOR;
/**
 * Custom exception class to handle cases where a gym center is not found.
 * This class extends RuntimeException and allows for a custom error message.
 */
public class CenterNotFoundException extends RuntimeException{
    /**
     * Constructor for CenterNotFoundException.
     * It takes a gymId as a parameter, which is included in the error message.
     *
     * @param gymId The ID of the gym center that was not found.
     */
    public CenterNotFoundException(String gymId){
        // Calling the constructor of the superclass (RuntimeException) with the colored message
        super(RED_COLOR+"Gym Centre" + gymId + " not found!"+RESET_COLOR);
    }
}