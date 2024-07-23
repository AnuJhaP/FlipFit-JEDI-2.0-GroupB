package com.flipkart.exceptions;

import static com.flipkart.constant.FlipFitConstant.RED_COLOR;
import static com.flipkart.constant.FlipFitConstant.RESET_COLOR;

/**
 * Exception thrown when registration fails for a customer.
 * This exception indicates that the customer registration process could not be completed successfully.
 */
public class RegisterationFailedForCustomerException extends Exception {
    /**
     * Constructs a RegisterationFailedForCustomerException with the specified user ID.
     *
     * @param userId The ID of the customer for whom registration failed.
     */
    public RegisterationFailedForCustomerException(String userId) {
        super(RED_COLOR+"Failed to register customer with id: " + userId+RESET_COLOR);

    }
}
