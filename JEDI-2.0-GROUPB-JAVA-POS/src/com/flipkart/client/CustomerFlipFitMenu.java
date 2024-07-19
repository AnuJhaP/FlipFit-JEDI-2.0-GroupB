package com.flipkart.client;

import com.flipkart.bean.*;
import com.flipkart.business.CustomerService;
import com.flipkart.business.CustomerServiceImpl;
import com.flipkart.utils.CustomerPlan;
import com.flipkart.utils.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.flipkart.client.FlipFitApplicationClient.scanner;
import static com.flipkart.constant.FlipFitConstant.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class CustomerFlipFitMenu {

    private CustomerService customerService = new CustomerServiceImpl();
    public void customerRegister() throws ParseException {


        System.out.println("Registering Customer.........");
        System.out.println("Enter your User Name");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();


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

        customerService.registerCustomer(userName,password,email,phoneNumber);
        customerClientMainPage(userName);
    }

    public void customerClientMainPage(String userName) throws ParseException {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = currentTime.format(myFormat);
        System.out.println("WELCOME "+userName+" !!\nWhat you what to do\nLogin TIME: "+currentTime);
        while(true) {
            System.out.println("1. View My Profile \n2. Book a slot in a Gym \n3. View Bookings\n4. Cancel Bookings\n5. Go Back to previous menu");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    FlipFitCustomer customer = customerService.viewMyProfile(userName);
                    util.printCustomerProfile(customer);
                    break;
                case 2:
                    bookSlotSubMenu(userName);
                    break;
                case 3:
                    printUserPlan(userName);
                    break;
                case 4:
                    cancelBookingSubMenu(userName);
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

    private void bookSlotSubMenu(String userId) throws ParseException {

        String location = scanner.next();
        List<FlipFitCenter> centreListByLocation = customerService.getAllGymCenterDetailsByCity(location);

        util.printGymCentres(centreListByLocation);
        if(centreListByLocation.isEmpty()){
            System.out.println(RED_COLOR +"There are no available GYM Centres in " + location + ". Please Select some other location" + RESET_COLOR);
            bookSlotSubMenu(userId);
            return;
        }
        System.out.print("Choose a gymCentre ID to proceed:");
        String chosenGym = scanner.next();
        Date sqlDate = selectDate();
        chooseSlot(chosenGym,userId,sqlDate,chosenGym);
    }
    private Date selectDate() throws ParseException {
        System.out.print("Enter Date (dd/MM/yyyy): ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        Date sqlDate = null;

        String dat = scanner.next();
        date = sdf.parse(dat);
        sqlDate = new Date(date.getTime());

        return sqlDate;
    }

    private void printUserPlan(String userName){
        System.out.println("Bookings : ");
        List<CustomerPlan> allUserPlan= customerService.getCustomerPlan(userName);
        List<FlipFitBooking> bookingList = customerService.getCustomerBookings(userName);
        System.out.println(DASHED_LINE);
        System.out.printf(YELLOW_COLOR + "%-8s\t", "Centre-ID");
        System.out.printf(YELLOW_COLOR + "%-8s\t", "SLOT-ID");
        System.out.printf(YELLOW_COLOR + "%-8s\t", "DATE");
        System.out.printf(YELLOW_COLOR + "%8s\t", "SLOT-TIME");
        System.out.printf("%-8s\t\n", "SCHEDULE_ID" + RESET_COLOR);
        System.out.println(DASHED_LINE);
        for(CustomerPlan userPlan: allUserPlan) {
            System.out.printf("%-8s\t", userPlan.getCentreID());
            System.out.printf("%-8s\t", userPlan.getSlotId());
            System.out.printf("%-8s\t", userPlan.getDate());
            System.out.printf("%-8s\t", userPlan.getTime());
            System.out.printf("%-8s\t\n", userPlan.getScheduleID());
        }
        System.out.println(DASHED_LINE);
    }
    private void chooseSlot(String gymCentreId,String userName,Date sqlDate,String centreId) throws ParseException {
        System.out.println("Choose from the Below Slots");
        List<FlipFitSlot> availableSlots = customerService.getAvailableSlots(gymCentreId,sqlDate);
        printSlots(availableSlots);
        if(availableSlots.isEmpty()){
            System.out.println(RED_COLOR +"There are no available slots in the " + gymCentreId + ". Please Select some other gym" + RESET_COLOR);
            bookSlotSubMenu(userName);
            return;
        }
        System.out.println("Enter SlotID");
        String slotID = scanner.next();
        //Select Slot to book
        if(!customerService.bookSlot(userName,sqlDate,slotID,centreId)) chooseSlot(gymCentreId, userName, sqlDate,centreId);
    }

    private void printSlots(List<FlipFitSlot> slots){
        System.out.println("-------------------------------");
        System.out.printf("%-8s\t", "SLOT-ID");
        System.out.printf("%-8s\t\n", "SLOT-TIME" );
        System.out.println("-------------------------------");
        for(FlipFitSlot slot: slots) {
            System.out.printf("%-8s\t", slot.getSlotId());
            System.out.printf("%-8s\t\n", slot.getStartTime());
        }
        System.out.println(DASHED_LINE);
    }



}