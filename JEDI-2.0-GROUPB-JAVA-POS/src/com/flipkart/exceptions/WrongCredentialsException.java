package com.flipkart.exceptions;

import static com.flipkart.constant.FlipFitConstant.RED_COLOR;
import static com.flipkart.constant.FlipFitConstant.RESET_COLOR;

public class WrongCredentialsException extends Exception {
    public WrongCredentialsException() {
        super(RED_COLOR+"Wrong username or password!"+RESET_COLOR);
    }
}