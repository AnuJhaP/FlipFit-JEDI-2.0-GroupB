package com.flipkart.exceptions;

import static com.flipkart.constant.FlipFitConstant.RED_COLOR;
import static com.flipkart.constant.FlipFitConstant.RESET_COLOR;

public class RegisterationFailedForCustomerException extends Exception {
    public RegisterationFailedForCustomerException(String userId) {
        super(RED_COLOR+"Failed to register customer with id: " + userId+RESET_COLOR);

    }
}
