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
        System.out.println("1. Login\n2. Register\n3. Change Password\n4. Exit");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                register();
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

    private static void register(){
        try {

            System.out.println("Enter your role");
            Role role=Role.valueOf(scanner.next());

            switch (role){
                case ADMIN:
                    adminClient.adminRegister();
                    break;
                case GYMOWNER:
                    gymOwnerClient.gymOwnerRegister();
                    break;
                case CUSTOMER:
                    customerClient.customerRegister();
                    break;
                default:
                    System.out.println(INVALID_CHOICE_ERROR);
                    break;
            }
        }catch (IllegalArgumentException e){
            System.out.println(INVALID_CHOICE_ERROR);
        }
    }

    private static void login(){
        try {
            System.out.println("Enter your Email ID");
            String email = scanner.next();
            System.out.println("Enter your Password");
            String password = scanner.next();

//            switch (role){
//                case ADMIN:
//                    adminClient.adminLogin(email,password);
//                    break;
//                case GYMOWNER:
//                    gymOwnerClient.gymOwnerLogin(email,password);
//                    break;
//                case CUSTOMER:
//                    customerClient.customerLogin(email,password);
//                    break;
//                default:
//                    System.out.println(INVALID_CHOICE_ERROR);
//                    break;
//            }
        }catch (IllegalArgumentException e){
            System.out.println(INVALID_CHOICE_ERROR);
        }
    }

    private static void changePassword(){

    }

    public static void main(String[] args) {
        System.out.println("WELCOME_MESSAGE");
        mainPage();
    }
}