package com.flipkart.client;
import com.flipkart.bean.Address;
import com.flipkart.bean.Role;


import java.util.Scanner;

import static com.flipkart.constant.Constants.*;

public class MainApplicationClient {

    public static int userId = 0;
    public static Scanner scanner = new Scanner(System.in);
    private static AdminClient adminClient = new AdminClient();
    private static CustomerClient customerClient = new CustomerClient();
    private static GymOwnerClient gymOwnerClient = new GymOwnerClient();


    private static void mainPage(){
        System.out.println("1. Sign in\n2. Sign up\n4. Change Password\n5. Exit");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                signin();
                break;
            case 2:
                signup();
                break;
            case 3:
                changePassword();
                break;
            case 4:
                System.out.println("EXIT_MESSAGE");
                return;
            default:
                System.out.println("INVALID_CHOICE_ERROR");
                break;
        }
        mainPage();
    }

    private static void signup(){
        try {
            System.out.println("Enter your First Name");
            String firstName = scanner.next();

            System.out.println("Enter your Last Name");
            String lastName = scanner.next();

            System.out.println("Enter your Email Id");
            String email = scanner.next();

            System.out.println("Enter your Password");
            String password = scanner.next();

            System.out.println("Enter your Phone Number");
            String phoneNumber = scanner.nextIn();

            System.out.println("Enter your Age");
            String age = scanner.nextIn();

            System.out.println("Enter your Role");
            Role role = Role.valueOf(scanner.next());



            System.out.println("Enter your Address - City:");
            String city = scanner.next();
            System.out.println("Enter your Address - State:");
            String state = scanner.next();
            System.out.println("Enter your Address - Pin Code:");
            String pinCode = scanner.next();
            System.out.println("Enter your Address - Street Address:");
            String streetAddress = scanner.next();

            Address address = new Address(city, state, pincode, streetAddress);

            switch (role){
                case ADMIN:
                    adminClient.adminLogin(userName,password);
                    break;
                case GYMOWNER:
                    gymOwnerClient.gymOwnerLogin(userName,password);
                    break;
                case CUSTOMER:
                    customerClient.customerLogin(userName,password);
                    break;
                default:
                    System.out.println(INVALID_CHOICE_ERROR);
                    break;
            }
        }catch (IllegalArgumentException e){
            System.out.println(INVALID_CHOICE_ERROR);
        }
    }

//    private static void signin(){
//        try {
//            System.out.println("Enter your role");
//            Role role = Role.valueOf(scanner.next().toUpperCase());
//
//            switch (role){
//                case ADMIN:
//                    System.out.println("Admin is already registered");
//                    mainPage();
//                    break;
//                case CUSTOMER:
//                    customerClient.register();
//                    break;
//                case GYMOWNER:
//                    gymOwnerClient.register();
//                    break;
//                default:
//                    System.out.println(INVALID_CHOICE_ERROR);
//                    break;
//            }
//        }catch (IllegalArgumentException e){
//            System.out.println(INVALID_CHOICE_ERROR);
//        }
//    }

    public static void main(String[] args) {
        System.out.println("WELCOME_MESSAGE");
        mainPage();
    }
}