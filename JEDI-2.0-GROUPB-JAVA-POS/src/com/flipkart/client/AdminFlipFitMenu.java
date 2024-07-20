package com.flipkart.client;

import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitCenter;
import com.flipkart.business.AdminService;
import com.flipkart.business.AdminServiceImpl;
import com.flipkart.exceptions.LoginFailedException;

import static com.flipkart.client.FlipFitApplicationClient.scanner;
import static com.flipkart.constant.FlipFitConstant.*;

import java.util.Scanner;
import java.util.List;


//    private static Scanner scanner = new Scanner(System.in);
//    private AdminService adminService = new AdminServiceImpl();
//    public void AdminMenu(){
//        System.out.println("Welcome to Flipkart Admin Menu");
//        System.out.println("1. View Pending Gym Owner Requests\n2. Approve Pending Gym Owner Requests\n3. View Pending Gym Center Requests\n4. Approve Pending Gym Center Requests\n5.  Exit");
//        int option = scanner.nextInt();
//        switch(option){
//            case 1:
//                viewPendingGymOwnerRequests();
//                break;
//            case 2:
//                approvePendingGymOwnerRequests();
//                break;
//            case 3:
//                viewPendingGymCenterRequests();
//                break;
//            case 4:
//                approvePendingGymCenterRequests();
//                break;
//            case 5:
//                System.out.println("exit");
//                return;
//            default:
//                System.out.println("invalid_choice_error");
//                break;
//        }
//        AdminMenu();
//    }
//    private void viewPendingGymOwnerRequests(){
//
//        System.out.println("You have following pending Gym Owner Requests: ");
//        List<FlipFitGymOwner> allPendingOwnerRequests= adminService.viewPendingOwners();
//        System.out.println(TB_DASHED_LINE);
//        System.out.printf(YELLOW_COLOR + "%-8s\t", "Aadhar No. ");
//        System.out.printf("%47s\t", "Owner ID ");
//        System.out.printf("%47s\t", "Account No. ");
//        System.out.printf("%47s\t", "PAN ");
//        System.out.printf("%47s\t", "GSTIN ");
//        System.out.printf("%47s\t\n", "IFSC Code" + RESET_COLOR);
//
//        System.out.println(TB_DASHED_LINE);
//        for(FlipFitGymOwner owner: allPendingOwnerRequests) {
////            System.out.printf("%-8s\t", owner.getAadharNo());
////            System.out.printf("%-8s\t", owner.getOwnerId());
////            System.out.printf("%-8s\t", owner.getAccountNo());
////            System.out.printf("%-8s\t", owner.getPAN());
////            System.out.printf("%-8s\t", owner.getGSTIN());
////            System.out.printf("%-8s\t\n", owner.getIFSCCode());
//        }
//        System.out.println(TB_DASHED_LINE);
//    };
//    private void approvePendingGymOwnerRequests(){
//
//        System.out.println("Please enter the Gym Owner ID you would like to approve/disapprove: ");
//        viewPendingGymOwnerRequests();
//        String gymOwnerID = scanner.nextLine();
//        System.out.println("1. Approve the request\n 2. Disapprove the request\n 3. Exit");
//        int option = scanner.nextInt();
//        switch(option){
//            case 1:
//                adminService.validateOwner(gymOwnerID,Boolean.TRUE);
//                System.out.println("Request approved successfully");
//                break;
//            case 2:
//                adminService.validateOwner(gymOwnerID,Boolean.FALSE);
//                System.out.println("Request disapproved successfully");
//                break;
//            case 3:
//                System.out.println("exit");
//                return;
//            default:
//                System.out.println("invalid_choice_error");
//                break;
//        }
//    };
//    private void viewPendingGymCenterRequests(){
//
//        System.out.println("You have following pending Gym Center Requests: ");
//        List<FlipFitCenter> allPendingCenterRequests= adminService.viewPendingCentres();
//        System.out.println(TB_DASHED_LINE);
//        System.out.printf(YELLOW_COLOR + "%-8s\t", "Center ID ");
//        System.out.printf("%47s\t", "Center Name");
//        System.out.printf("%47s\t", "Owner ID ");
//        System.out.printf("%47s\t", "City ");
//        System.out.printf("%47s\t", "Price ");
//        System.out.printf("%47s\t\n", "Capacity" + RESET_COLOR);
//
//        System.out.println(TB_DASHED_LINE);
//        for(FlipFitCenter center: allPendingCenterRequests) {
//            System.out.printf("%-8s\t", center.getGymCentreID());
//            System.out.printf("%-8s\t", center.getGymCenterName());
//            System.out.printf("%-8s\t", center.getOwnerID());
//            System.out.printf("%-8s\t", center.getCity());
//            System.out.printf("%-8s\t", center.getPrice());
//            System.out.printf("%-8s\t\n", center.getCapacity());
//        }
//        System.out.println(TB_DASHED_LINE);
//    };
//    private void approvePendingGymCenterRequests(){
//
//        System.out.println("Please enter the Gym Center ID you would like to approve/disapprove: ");
//        viewPendingGymCenterRequests();
//        String gymCenterID = scanner.nextLine();
//        System.out.println("1. Approve the request\n 2. Disapprove the request\n 3. Exit");
//        int option = scanner.nextInt();
//        switch(option){
//            case 1:
//                adminService.validateCenter(gymCenterID,Boolean.TRUE);
//                System.out.println("Request approved successfully");
//                break;
//            case 2:
//                adminService.validateCenter(gymCenterID,Boolean.FALSE);
//                System.out.println("Request disapproved successfully");
//                break;
//            case 3:
//                System.out.println("exit");
//                return;
//            default:
//                System.out.println("invalid_choice_error");
//                break;
//        }
//    };
//}
import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.business.AdminService;
import com.flipkart.business.AdminServiceImpl;
import com.flipkart.business.GymOwnerService;
import com.flipkart.business.GymOwnerServiceImpl;
import com.flipkart.exceptions.LoginFailedException;
import com.flipkart.utils.FlipFitUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static com.flipkart.client.FlipFitApplicationClient.scanner;
import static com.flipkart.constant.FlipFitConstant.*;

public class AdminFlipFitMenu {

        private static FlipFitAdmin admin = new FlipFitAdmin();
        private static AdminServiceImpl adminService = new AdminServiceImpl();
        private static GymOwnerService gymOwnerService = new GymOwnerServiceImpl();

        public boolean isUserValid(String userName, String password) {
            if (userName.equals(admin.getUserName()) && password.equals(admin.getPassword())) {
                return true;
            }
            return false;
        }

        public boolean adminLogin(String userName, String password) {
            if (isUserValid(userName, password)) {
                System.out.println("Successfully logged in");
                adminClientMainPage();
            }
            else{
                new LoginFailedException("Admin Login Failed");
                return false;
            }
            return true;
        }

        private void handleGymOwnerApprovalRequests(){
            // print the list with indexes from 1
            System.out.println("Admin Approval for a Gym Owner ----------");

            System.out.println("(Press 0 to exit)\nEnter the Id of Gym Owner:");
            String requestGymOwnerId = scanner.next();

            if(requestGymOwnerId.equals("0")) {return;}

            System.out.println("1. Approve the request\n2. Reject the request");
            int choice = scanner.nextInt();
            if(choice == 1){
                System.out.println("APPROVAL GYM OWNER CONFIRMATION");
            } else if (choice == 2) {
                System.out.println("DISAPPROVAL GYM OWNER CONFIRMATION");
            }

            adminService.validateOwner(requestGymOwnerId,choice);
        }
        private void handleGymCenterApprovalRequests(){
            System.out.println("Press 0 to EXIT_MESSAGE or Choose the Gym Centre To Modify:");
            String requestGymCenterId = scanner.next();
            if (requestGymCenterId.equals("0")) return;
            System.out.println("1. Approve the request\n2. Reject the request\n");
            int choice = scanner.nextInt();
            if(choice == 1){
                System.out.println("APPROVAL_GYM_CENTRE_CONFIRMATION");
            } else if (choice == 2) {
                System.out.println("DISAPPROVAL_GYM_CENTRE_CONFIRMATION");
            }
            adminService.validateCenter(requestGymCenterId,choice);
        }

        private void printOwnerList(List<FlipFitGymOwner> gymOwnerList){
            System.out.println(DASHED_LINE);
            System.out.printf(YELLOW_COLOR + "%-8s\t", "ID");
            System.out.printf("%-8s\t", "NAME");
            System.out.printf("%-8s\t", "EMAIL-ID");
            System.out.printf("%11s\t", "PAN");
            System.out.printf("%23s\t\n", "IS-APPROVED" + RESET_COLOR);
            System.out.println(DASHED_LINE);
            System.out.println("");
            for(FlipFitGymOwner gymOwner: gymOwnerList) {
                System.out.printf("%-8s\t", gymOwner.getUserId());
                System.out.printf("%-8s\t", gymOwner.getUserName());
                System.out.printf("%-8s\t", gymOwner.getEmailId());
                System.out.printf("%-8s\t", gymOwner.getPanNumber());
                if(gymOwner.getIsApproved()==1)
                {
                    System.out.println("Yes\n");
                }
                else if(gymOwner.getIsApproved() == 0)
                {
                    System.out.println("No\n");
                } else {
                    System.out.println("Pending\n");
                }
            }
            System.out.println(DASHED_LINE);
        }

        public void adminClientMainPage(){
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = currentTime.format(myFormat);
            System.out.println(YELLOW_COLOR+"WELCOME ADMIN!!\nLogin Time: "+currentTime+RESET_COLOR);
            while(true){
                System.out.println("0. View All Gym Owners\n1. View Pending GymOwner Approval Requests\n2. View Pending GymCenter's Approval Requests\n3. Go Back To Previous Menu");
                int pendingChoice = scanner.nextInt();
                switch (pendingChoice) {
                    case 0:
                        List<FlipFitGymOwner> allGymOwners =  gymOwnerService.viewAllGymOwners();
                        printOwnerList(allGymOwners);
                        break;
                    case 1:
                        List<FlipFitGymOwner> pendingGymOwners = adminService.viewPendingOwners();
                        printOwnerList(pendingGymOwners);
                        if(!pendingGymOwners.isEmpty()) handleGymOwnerApprovalRequests();
                        break;

                    case 2:
                        List<FlipFitCenter> pendingGymCentres = adminService.viewPendingCentres();//get listGymCenterIds
                        FlipFitUtils.printGymCentres(pendingGymCentres);
                        if(!pendingGymCentres.isEmpty()) handleGymCenterApprovalRequests();
                        break;
                    case 3:
                        return;
                }
            }
        }

    }}