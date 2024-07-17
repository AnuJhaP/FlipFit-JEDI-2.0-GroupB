package com.flipkart.client;

import com.flipkart.bean.Address;

import java.util.Scanner;

public class CustomerClient {
    //customer login function


    //customer register function

    public void customerRegister(){


        System.out.println("Registering Customer.........");
        System.out.println("Enter your First name.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your Last name.");
        String firstName = scanner.nextLine();

        System.out.println("Enter your email address.");
        String email = scanner.nextLine();

        System.out.println("Enter your password.");
        String password = scanner.nextLine();

        System.out.println("Enter your password again.");
        String passwordAgain = scanner.nextLine();

        System.out.println("Enter your phone number.");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter your age.");
        int age = scanner.nextInt();

        System.out.println("Enter your Address - City:");
        String city = scanner.next();
        System.out.println("Enter your Address - State:");
        String state = scanner.next();
        System.out.println("Enter your Address - Pin Code:");
        String pinCode = scanner.next();
        System.out.println("Enter your Address - Street Address:");
        String streetAddress = scanner.next();

        Address address = new Address(city, state, pinCode, streetAddress);

        System.out.println("Customer Registered Successfully.");
    }

}

