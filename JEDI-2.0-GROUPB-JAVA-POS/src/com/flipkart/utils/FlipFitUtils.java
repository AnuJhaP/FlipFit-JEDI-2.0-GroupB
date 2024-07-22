package com.flipkart.utils;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitCustomer;

import java.util.List;

import static com.flipkart.constant.FlipFitConstant.*;

public class FlipFitUtils {
    public void printCustomerProfile(FlipFitCustomer customer){
        System.out.println(GREEN_COLOR +"------------------------------------------------------------------------" + RESET_COLOR);
        System.out.println(YELLOW_COLOR + "USER ID: "+ RESET_COLOR + customer.getUserId());
        System.out.println(YELLOW_COLOR + "USER NAME: "+ RESET_COLOR + customer.getUserName());
        System.out.println(YELLOW_COLOR + "EMAIL: "+ RESET_COLOR + customer.getEmailId());
        System.out.println(YELLOW_COLOR + "CONTACT: "+ RESET_COLOR + customer.getCustomerPhone());
        System.out.println(GREEN_COLOR +"------------------------------------------------------------------------" + RESET_COLOR);
    }

    public static void printGymCentres(List<FlipFitCenter> gymCentres){
        System.out.println(DASHED_LINE);
        System.out.printf(YELLOW_COLOR + "%-8s\t", "CENTRE-ID");
        System.out.printf("%-8s\t", "NAME");
        System.out.printf("%-6s\t", "CITY");
        System.out.printf("%12s\t", "OWNER-ID");
        System.out.printf("%8s\t", "CAPACITY");
        System.out.printf("%-8s\t\n", "IS-APPROVED" + RESET_COLOR);
        System.out.println(DASHED_LINE);
        System.out.println("");
        for(FlipFitCenter gymCentre: gymCentres) {
            System.out.printf("%-8s\t", gymCentre.getGymCenterID());
            System.out.printf("%-8s\t", gymCentre.getGymCenterName());
            System.out.printf("%-8s\t", gymCentre.getCity());
            System.out.printf("%-8s\t", gymCentre.getOwnerID());
            System.out.printf("%-8s\t", gymCentre.getCapacity());
            if(gymCentre.isApproved() == 0) System.out.println("No\n");
            else if(gymCentre.isApproved() == 1) System.out.println("Yes\n");
            else System.out.println("Pending\n");
        }
        System.out.println(DASHED_LINE);
    }

}
