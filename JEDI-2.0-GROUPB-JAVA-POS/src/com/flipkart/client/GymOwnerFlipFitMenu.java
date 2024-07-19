package com.flipkart.client;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitSlot;
import com.flipkart.business.GymCenterServiceImpl;
import com.flipkart.business.GymOwnerServiceImpl;
import com.flipkart.business.SlotServiceImpl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GymOwnerFlipFitMenu {
    private Scanner scanner = new Scanner(System.in);
    private GymOwnerServiceImpl gymOwnerService = new GymOwnerServiceImpl();
    private SlotServiceImpl slotService = new SlotServiceImpl();
    private GymCenterServiceImpl gymCentreService = new GymCenterServiceImpl();
    public void gymOwnerRegister() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your UserName");
        String userName = scanner.next();

        System.out.println("Enter your Password");
        String password = scanner.next();

        System.out.println("Enter your Email");
        String email = scanner.next();

        System.out.println("Enter your PAN Number");
        String panNumber = scanner.next();

        System.out.println("Enter your Card Number");
        String cardNumber = scanner.next();

        gymOwnerService.registerGymOwner(userName,userName,password,email,panNumber,cardNumber);
        gymOwnerClientMainPage(userName);
    }


    public void gymOwnerClientMainPage(String gymOwnerId) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = currentTime.format(myFormat);
//        System.out.println("WELCOME "+gymOwnerId+" !!\nWhat you what to do\nLogin TIME: "+currentTime);
        while(true){
            System.out.println("" +
                    "0. View all my Gym Centres\n" +
                    "1. Sending Gym Owner Approval Request\n" +
                    "2. Add a new Gym Center\n" +
                    "3. Send a Gym Centre Approval Request to Admin\n" +
                    "4. Add Slots to a Gym Centre\n" +
                    "5. Go Back to Previous Menu"
            );
            int choice = scanner.nextInt();
            switch (choice){


                case 0:
                    List<FlipFitCenter> allGymCentres = gymCentreService.getAllCentresByOwmerId(gymOwnerId);
                    break;

                case 1:
                    gymOwnerService.requestGymOwnerApproval(gymOwnerId);
                    break;

                case 2:

                    System.out.println("Enter gym centre id: ");
                    String gymId = scanner.next();

                    System.out.println("Enter Gym Centre name: ");
                    String gymCentreName = scanner.next();

                    System.out.println("Enter Gym Centre city: ");
                    String city = scanner.next();

                    System.out.println("Enter Gym Centre capacity: ");
                    int capacity = scanner.nextInt();

                    System.out.println("Enter price: : ");
                    int price = scanner.nextInt();

                    gymCentreService.addCenter(
                            new FlipFitCenter(
                                    gymId,
                                    gymOwnerId,
                                    gymCentreName,
                                    city,
                                    price,
                                    capacity,
                                    true
                            )
                    );
                    break;

                case 3:

                    System.out.println("Enter Gym Centre Id: ");
                    String gymCentreId = scanner.next();

                    gymCentreService.requestGymCentreApproval(gymCentreId);
                    break;

                case 4:

                    boolean isAdding = true;
                    String centreId = null;

                    List<FlipFitSlot> newSlotList = new ArrayList<>();
                    while (isAdding) {
                        System.out.println("Enter new slot id: ");
                        String slotId = scanner.next();

                        System.out.println("Enter Gym Centre Id: ");
                        centreId = scanner.next();

                        System.out.println("Enter time in 24h format (hh:mm:ss) : ");
                        String time = scanner.next();

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                        LocalTime localTime = LocalTime.parse(time, formatter);

                        newSlotList.add(new FlipFitSlot(
                                slotId,
                                localTime,
                                centreId
                        ));

                        System.out.println("Do you want to enter more slots (y/n)?: ");
                        String addChoice = scanner.next();
                        addChoice = addChoice.toLowerCase();

                        if(addChoice.equals("n") || addChoice.equals("no")) {
                            isAdding = false;
                        }
                    }

                    slotService.bookSlots(centreId, newSlotList);
                    break;
                case 5:
                    System.out.println("PREVIOUS_MENU_MESSAGE");
                    return;
                default:
                    System.out.println("INVALID_CHOICE_ERROR");
                    break;
            }
        }
    }
}