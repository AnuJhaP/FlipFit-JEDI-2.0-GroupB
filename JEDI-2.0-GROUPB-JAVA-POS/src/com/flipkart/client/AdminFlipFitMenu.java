package com.flipkart.client;

import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitCenter;
import com.flipkart.business.AdminService;
import com.flipkart.business.AdminServiceImpl;
import com.flipkart.dao.AdminDAO;
import com.flipkart.exceptions.LoginFailedException;

import static com.flipkart.client.FlipFitApplicationClient.scanner;
import static com.flipkart.constant.FlipFitConstant.*;

import java.util.Scanner;
import java.util.List;

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
            if (adminService.isUserValid(userName, password)) {
                //adminService.isUserValid(userName,password);
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

    }