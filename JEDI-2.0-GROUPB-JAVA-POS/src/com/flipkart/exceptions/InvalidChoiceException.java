package com.flipkart.exceptions;

import java.io.InvalidObjectException;

import static com.flipkart.constant.FlipFitConstant.RED_COLOR;
import static com.flipkart.constant.FlipFitConstant.RESET_COLOR;

public class InvalidChoiceException extends InvalidObjectException {
    public InvalidChoiceException(){
        super(RED_COLOR+"Please enter valid choice"+RESET_COLOR);
    }
}