package com.flipkart.utils;

import com.flipkart.bean.FlipFitCustomer;

import static com.flipkart.constant.FlipFitConstant.*;

public class FlipFitUtils {
    public void printCustomerProfile(FlipFitCustomer customer){
        System.out.println(GREEN_COLOR +"------------------------------------------------------------------------" + RESET_COLOR);
        System.out.println(YELLOW_COLOR + "USER ID: "+ RESET_COLOR + customer.getUserId());
        System.out.println(YELLOW_COLOR + "USER NAME: "+ RESET_COLOR + customer.getUserName());
        System.out.println(YELLOW_COLOR + "EMAIL: "+ RESET_COLOR + customer.getEmailId());
        System.out.println(YELLOW_COLOR + "CONTACT: "+ RESET_COLOR + customer.getPhoneNumber());
        System.out.println(GREEN_COLOR +"------------------------------------------------------------------------" + RESET_COLOR);
    }

}
