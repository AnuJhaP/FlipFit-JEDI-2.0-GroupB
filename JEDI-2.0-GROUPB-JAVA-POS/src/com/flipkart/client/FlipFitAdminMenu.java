package com.flipkart.client;

import com.flipkart.bean.FlipFitAdmin;

import java.util.Scanner;

public class FlipFitAdminMenu {
    private static Scanner scanner = new Scanner(System.in);
    public void AdminMenu(){
        System.out.println("Welcome to Flipkart Admin Menu");
        System.out.println("1. View Pending Gym Owner Requests\n2. Approve Pending Gym Owner Requests\n3. View Pending Gym Center Requests\n4. Approve Pending Gym Center Requests\n4.  Exit");
        int option = scanner.nextInt();
        switch(option){
            case 1:
                viewPendingGymOwnerRequests();
                break;
            case 2:
                approvePendingGymOwnerRequests();
                break;
            case 3:
                viewPendingGymCenterRequests();
                break;
            case 4:
                approvePendingGymCenterRequests();
                break;
            case 5:
                System.out.println("exit");
                return;
            default:
                System.out.println("invalid_choice_error");
                break;
        }
        AdminMenu();
    }
    private void viewPendingGymOwnerRequests(){};
    private void approvePendingGymOwnerRequests(){};
    private void viewPendingGymCenterRequests(){};
    private void approvePendingGymCenterRequests(){};
}
