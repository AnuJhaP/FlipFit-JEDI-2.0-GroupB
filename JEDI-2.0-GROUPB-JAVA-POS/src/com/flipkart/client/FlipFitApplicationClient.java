package com.flipkart.client;

import com.flipkart.bean.Role;
import java.util.Random;
import java.util.Scanner;

import static com.flipkart.bean.Role.*;
import static com.flipkart.constant.FlipFitConstant.*;
import com.flipkart.constant.FlipFitConstant;
import com.flipkart.java17.DateAndTime;

/**
 * @ JEDI-02
 * FlipFitApplicationClient class manages the main application flow for FlipFit.
 */
public class FlipFitApplicationClient {


    public static int userId = 0;
    public static Scanner scanner = new Scanner(System.in);
    private static AdminFlipFitMenu adminClient = new AdminFlipFitMenu();
    private static CustomerFlipFitMenu customerClient = new CustomerFlipFitMenu();
    private static GymOwnerFlipFitMenu gymOwnerClient = new GymOwnerFlipFitMenu();

    /**
     * Displays the main page of the application with options: Login, Registration, and Exit.
     */
    private static void mainPage(){
        System.out.println("1. Login\n2. Registration\n3. Exit");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                registration();
                break;
            case 3:
                System.out.println(EXIT_MESSAGE);
                return;
            default:
                System.out.println(INVALID_CHOICE_ERROR);
                break;
        }
        mainPage();
    }

    /**
     * Handles the login process based on user role.
     */
    private static void login(){
        try {
            System.out.println("Enter your Role");
            Role role = Role.valueOf(scanner.next().toUpperCase());

            System.out.println("Enter your UserName");
            String userName = scanner.next();

            System.out.println("Enter your Passkey");
            String password = scanner.next();

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

    /**
     * Handles the registration process based on user role.
     */
    private static void registration(){
        try {
            System.out.println("Enter your role");
            Role role = Role.valueOf(scanner.next().toUpperCase());

            switch (role){
                case ADMIN:
                    System.out.println("Admin is already registered");
                    mainPage();
                    break;
                case CUSTOMER:
                    customerClient.register();
                    break;
                case GYMOWNER:
                    gymOwnerClient.register();
                    break;
                default:
                    System.out.println(INVALID_CHOICE_ERROR);
                    break;
            }
        }catch (IllegalArgumentException e){
            System.out.println(INVALID_CHOICE_ERROR);
        }
    }

    /**
     * Entry point of the FlipFit application.
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);
        DateAndTime dateAndTime = new DateAndTime();
        DateAndTime.displayCurrentDate8to11();
        mainPage();
    }
}