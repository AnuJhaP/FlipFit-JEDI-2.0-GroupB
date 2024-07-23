package com.flipkart.exceptions;

import static com.flipkart.constant.FlipFitConstant.RED_COLOR;
import static com.flipkart.constant.FlipFitConstant.RESET_COLOR;
/**
 * Exception thrown when a Gym Owner with a specified ID is not found.
 */
public class GymOwnerNotFoundException extends Exception {
    /**
     * Constructs a GymOwnerNotFoundException with a message indicating the non-existence of the Gym Owner.
     *
     * @param gymOwnerId The ID of the Gym Owner that was not found.
     */
    public GymOwnerNotFoundException(String gymOwnerId){
        super(RED_COLOR+"Gym Owner with ID: " + gymOwnerId + " does not exist."+RESET_COLOR);
    }
}