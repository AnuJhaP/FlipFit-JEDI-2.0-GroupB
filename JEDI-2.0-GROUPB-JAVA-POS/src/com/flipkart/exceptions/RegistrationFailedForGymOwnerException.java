package com.flipkart.exceptions;

import static com.flipkart.constant.FlipFitConstant.RED_COLOR;
import static com.flipkart.constant.FlipFitConstant.RESET_COLOR;

public class RegistrationFailedForGymOwnerException extends Exception {
    public RegistrationFailedForGymOwnerException(String gymOwnerId) {
        super(RED_COLOR+"Failed to register Gym Owner with id: " + gymOwnerId+RESET_COLOR);
    }
}