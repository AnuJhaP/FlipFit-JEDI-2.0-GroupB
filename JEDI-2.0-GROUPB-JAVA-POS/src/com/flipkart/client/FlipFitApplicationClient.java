package com.flipkart.client;

import com.flipkart.bean.Role;

import java.text.ParseException;
import java.util.Random;
import java.util.Scanner;

import static com.flipkart.bean.Role.*;

public class FlipFitApplicationClient {

    public static int userId = 0;
    public static Scanner scanner = new Scanner(System.in);
    private static CustomerFlipFitMenu customerFlipFitMenu = new CustomerFlipFitMenu();
    private static GymOwnerFlipFitMenu gymOwnerFlipFitMenu = new GymOwnerFlipFitMenu();
    private static FlipFitAdminMenu flipFitAdminMenu = new FlipFitAdminMenu();


    private static void mainPage() throws ParseException {
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
                System.out.println("exit");
                return;
            default:
                System.out.println("invalid_choice_error");
                break;
        }
        mainPage();
    }

    private static void register() throws ParseException {

        System.out.println("Enter your role");
//        Role role=Role.valueOf(scanner.next());
        Role role = new Role("abs",scanner.next());

        switch (role.getRoleId()){
            case "ADMIN":
                System.out.println("Admin is already registered");
                mainPage();
                break;
            case "GYMOWNER":
                gymOwnerFlipFitMenu.gymOwnerRegister();
                break;
            case "CUSTOMER":
                customerFlipFitMenu.customerRegister();
                break;
            default:
                System.out.println("invalid_choice");
                break;
        }
    }

    private static void login() throws ParseException {
        System.out.println("Enter your User Name");
        String userName = scanner.next();

        System.out.println("Enter your Password");
        String password = scanner.next();

        System.out.println("Enter your role");
        Role role = new Role("abs",scanner.next());

        switch (role.getDescription()){
            case "ADMIN":
                flipFitAdminMenu.AdminMenu();
                break;
            case "GYMOWNER":
                gymOwnerFlipFitMenu.gymOwnerClientMainPage(userName);
                break;
            case "CUSTOMER":
                customerFlipFitMenu.customerClientMainPage(userName);
                break;
            default:
                System.out.println("invalid_choice");
                break;
        }

        System.out.println("You have been successfully logged in");

    }

    private static void changePassword(){

    }

    public static void main(String[] args) throws ParseException {
        System.out.println("Welcome TO FlipFit");
        mainPage();
    }
}