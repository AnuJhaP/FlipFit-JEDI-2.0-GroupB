package com.flipkart.client;

import com.flipkart.bean.Address;
import com.flipkart.bean.FlipFitBooking;
import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.business.CustomerService;
import com.flipkart.business.CustomerServiceImpl;
import com.flipkart.utils.FlipFitUtils;

import static com.flipkart.client.FlipFitApplicationClient.scanner;
import static com.flipkart.constant.FlipFitConstant.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CustomerFlipFitMenu {

    private CustomerService customerService = new CustomerServiceImpl();
    private FlipFitUtils utils = new FlipFitUtils();
    public void customerRegister(){


        System.out.println("Registering Customer.........");
        System.out.println("Enter your First name.");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        System.out.println("Enter your Last name.");
        String lastName = scanner.nextLine();

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

        String userId = customerService.registerCustomer(firstName,lastName,password,email,phoneNumber);
        customerClientMainPage(firstName, userId);
    }

    private void customerClientMainPage(String firstName, String userId) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = currentTime.format(myFormat);
        System.out.println("WELCOME "+firstName+" !!\nWhat you what to do\nLogin TIME: "+currentTime);
        while(true) {
            System.out.println("1. View My Profile \n2. Book a slot in a Gym \n3. View Bookings\n4. Cancel Bookings\n5. Go Back to previous menu");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    FlipFitCustomer customer = customerService.viewMyProfile(userId);
                    utils.printCustomerProfile(customer);
                    break;
                case 2:
                    bookSlotSubMenu(userId);
                    break;
                case 3:
                    printUserPlan(userId);
                    break;
                case 4:
                    cancelBookingSubMenu(userId);
                    break;
                case 5:
                    System.out.println("\nGOING BACK TO PREVIOUS MENU\n");
                    return;
                default:
                    System.out.println("\nPlease enter valid choice\n");
                    break;
            }
        }
    }


    private void cancelBookingSubMenu(String userId){
        System.out.println("Select the Booking you want to cancel: ");
        printbookingsSubMenu(userId);
        String bookingId = scanner.next();
        customerService.cancelBookingbyID(bookingId);

    }

    private void printbookingsSubMenu(String userName){
        System.out.println("Bookings : ");
        List<FlipFitBooking> allBookingList= customerService.getCustomerBookings(userName);
        System.out.println(DASHED_LINE);
        System.out.printf(YELLOW_COLOR + "%-8s\t", "BOOKING-ID");
        System.out.printf("%47s\t\n", "SCHEDULE-ID" + RESET_COLOR);
        System.out.println(DASHED_LINE);
        for(FlipFitBooking booking: allBookingList) {
            System.out.printf("%-8s\t", booking.getBookingId());
           // System.out.printf("%-8s\t\n", booking.getScheduleID());
        }
        System.out.println(DASHED_LINE);
    }

    private void bookSlotSubMenu(String userId){
        System.out.println("Book Slot");
//        String location = scanner.next();
//        List<GymCentre> centreListByLocation = customerService.getAllGymCenterDetailsByCity(location);
//        // Print All Centres
//        utils.printGymCentres(centreListByLocation);
//        //Select Gym Centre
//        if(centreListByLocation.isEmpty()){
//            System.out.println(RED_COLOR +"There are no available GYM Centres in " + location + ". Please Select some other location" + RESET_COLOR);
//            bookSlotSubMenu(userName);
//            return;
//        }
//        System.out.print("Choose a gymCentre ID to proceed:");
//        String chosenGym = scanner.next();
//        //Select Date
//        Date sqlDate = selectDate();
//        //Choose Slot
//        chooseSlot(chosenGym,userName,sqlDate,chosenGym);
    }

    private void printUserPlan(String userId) {
        System.out.println("Print User Plan");

    }

}