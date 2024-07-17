package com.flipkart.client;

import java.util.Scanner;
public class GymOwnerFlipFitMenu {

    public void gymOwnerRegister() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your UserName");
        String userName = scanner.next();

        System.out.println("Enter your Passkey");
        String password = scanner.next();

        System.out.println("Enter your Email");
        String email = scanner.next();

        System.out.println("Enter your PAN Number");
        String panNumber = scanner.next();

        System.out.println("Enter your Card Number");
        String cardNumber = scanner.next();

//        gymOwnerService.registerGymOwner(userName,userName,password,email,panNumber,cardNumber);
//        gymOwnerClientMainPage(userName);
    }
}