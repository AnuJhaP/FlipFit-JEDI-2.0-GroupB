package com.flipkart.exceptions;

import static com.flipkart.constant.FlipFitConstant.RED_COLOR;
import static com.flipkart.constant.FlipFitConstant.RESET_COLOR;

/**
 * Exception thrown when registration fails for a Gym Owner.
 * This exception indicates that the Gym Owner registration process could not be completed successfully.
 */
public class RegistrationFailedForGymOwnerException extends Exception {
    /**
     * Constructs a RegistrationFailedForGymOwnerException with the specified Gym Owner ID.
     *
     * @param gymOwnerId The ID of the Gym Owner for whom registration failed.
     */
    public RegistrationFailedForGymOwnerException(String gymOwnerId) {
        super(RED_COLOR+"Failed to register Gym Owner with id: " + gymOwnerId+RESET_COLOR);
    }
}