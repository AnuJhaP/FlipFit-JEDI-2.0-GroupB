package com.flipkart.exceptions;

import static com.flipkart.constant.FlipFitConstant.RED_COLOR;
import static com.flipkart.constant.FlipFitConstant.RESET_COLOR;

public class GymOwnerNotFoundException extends Exception {
    public GymOwnerNotFoundException(String gymOwnerId){
        super(RED_COLOR+"Gym Owner with ID: " + gymOwnerId + " does not exist."+RESET_COLOR);
    }
}