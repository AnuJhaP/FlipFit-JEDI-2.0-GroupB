package com.flipkart.client;

import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitCenter;
import com.flipkart.business.AdminService;
import com.flipkart.business.AdminServiceImpl;
import static com.flipkart.constant.FlipFitConstant.*;

import java.util.Scanner;
import java.util.List;

public class AdminFlipFitMenu {
    private static Scanner scanner = new Scanner(System.in);
    private AdminService adminService = new AdminServiceImpl();
    public void AdminMenu(){
        System.out.println("Welcome to Flipkart Admin Menu");
        System.out.println("1. View Pending Gym Owner Requests\n2. Approve Pending Gym Owner Requests\n3. View Pending Gym Center Requests\n4. Approve Pending Gym Center Requests\n5.  Exit");
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
    private void viewPendingGymOwnerRequests(){

        System.out.println("You have following pending Gym Owner Requests: ");
        List<FlipFitGymOwner> allPendingOwnerRequests= adminService.viewPendingGymOwners();
        System.out.println(TB_DASHED_LINE);
        System.out.printf(YELLOW_COLOR + "%-8s\t", "Aadhar No. ");
        System.out.printf("%47s\t", "Owner ID ");
        System.out.printf("%47s\t", "Account No. ");
        System.out.printf("%47s\t", "PAN ");
        System.out.printf("%47s\t", "GSTIN ");
        System.out.printf("%47s\t\n", "IFSC Code" + RESET_COLOR);

        System.out.println(TB_DASHED_LINE);
        for(FlipFitGymOwner owner: allPendingOwnerRequests) {
            System.out.printf("%-8s\t", owner.getAadharNo());
            System.out.printf("%-8s\t", owner.getOwnerId());
            System.out.printf("%-8s\t", owner.getAccountNo());
            System.out.printf("%-8s\t", owner.getPAN());
            System.out.printf("%-8s\t", owner.getGSTIN());
            System.out.printf("%-8s\t\n", owner.getIFSCCode());
        }
        System.out.println(TB_DASHED_LINE);
    };
    private void approvePendingGymOwnerRequests(){

        System.out.println("Please enter the Gym Owner ID you would like to approve/disapprove: ");
        viewPendingGymOwnerRequests();
        String gymOwnerID = scanner.nextLine();
        System.out.println("1. Approve the request\n 2. Disapprove the request\n 3. Exit");
        int option = scanner.nextInt();
        switch(option){
            case 1:
                adminService.validateOwner(gymOwnerID,Boolean.TRUE);
                System.out.println("Request approved successfully");
                break;
            case 2:
                adminService.validateOwner(gymOwnerID,Boolean.FALSE);
                System.out.println("Request disapproved successfully");
                break;
            case 3:
                System.out.println("exit");
                return;
            default:
                System.out.println("invalid_choice_error");
                break;
        }
    };
    private void viewPendingGymCenterRequests(){

        System.out.println("You have following pending Gym Center Requests: ");
        List<FlipFitCenter> allPendingCenterRequests= adminService.viewPendingCentres();
        System.out.println(TB_DASHED_LINE);
        System.out.printf(YELLOW_COLOR + "%-8s\t", "Center ID ");
        System.out.printf("%47s\t", "Center Name");
        System.out.printf("%47s\t", "Owner ID ");
        System.out.printf("%47s\t", "City ");
        System.out.printf("%47s\t", "Price ");
        System.out.printf("%47s\t\n", "Capacity" + RESET_COLOR);

        System.out.println(TB_DASHED_LINE);
        for(FlipFitCenter center: allPendingCenterRequests) {
            System.out.printf("%-8s\t", center.getGymCentreID());
            System.out.printf("%-8s\t", center.getGymCenterName());
            System.out.printf("%-8s\t", center.getOwnerID());
            System.out.printf("%-8s\t", center.getCity());
            System.out.printf("%-8s\t", center.getPrice());
            System.out.printf("%-8s\t\n", center.getCapacity());
        }
        System.out.println(TB_DASHED_LINE);
    };
    private void approvePendingGymCenterRequests(){

        System.out.println("Please enter the Gym Center ID you would like to approve/disapprove: ");
        viewPendingGymCenterRequests();
        String gymCenterID = scanner.nextLine();
        System.out.println("1. Approve the request\n 2. Disapprove the request\n 3. Exit");
        int option = scanner.nextInt();
        switch(option){
            case 1:
                adminService.validateCenter(gymCenterID,Boolean.TRUE);
                System.out.println("Request approved successfully");
                break;
            case 2:
                adminService.validateCenter(gymCenterID,Boolean.FALSE);
                System.out.println("Request disapproved successfully");
                break;
            case 3:
                System.out.println("exit");
                return;
            default:
                System.out.println("invalid_choice_error");
                break;
        }
    };
}
