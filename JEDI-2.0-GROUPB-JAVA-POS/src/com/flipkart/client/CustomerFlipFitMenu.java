package com.flipkart.client;

import com.flipkart.bean.FlipFitBooking;
import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitSlot;
import com.flipkart.business.CustomerService;
import com.flipkart.business.CustomerServiceImpl;
import com.flipkart.exceptions.DataEntryException;
import com.flipkart.utils.UserPlan;
import com.flipkart.utils.FlipFitUtils;
import com.flipkart.validators.Validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.flipkart.client.FlipFitApplicationClient.scanner;
import static com.flipkart.constant.FlipFitConstant.*;
import static com.flipkart.constant.FlipFitConstant.RESET_COLOR;


/**
 * @author  JEDI-02
 * CustomerFlipFitMenu class provides functionality for Customer operations in FlipFit application.
 */
public class CustomerFlipFitMenu {
    private CustomerServiceImpl customerService  =  new CustomerServiceImpl();


    /**
     * Attempts to log in a customer with the provided credentials.
     * @param userName The username to log in with.
     * @param password The password to log in with.
     * @return true if login is successful, false otherwise.
     */
    public boolean customerLogin(String userName, String password) {
//        Check if credentials are right
        if (customerService.isUserValid(userName, password)) {
            System.out.println(GREEN_COLOR+"Successfully logged in"+RESET_COLOR);
            customerClientMainPage(userName);
        } else {
            System.out.println(RED_COLOR+"UserName or password doesn't match"+RESET_COLOR);
            return false;
        }
        return true;
    }

    /**
     * Registers a new customer with details provided by user input.
     */
    public void register(){
        System.out.println("Enter your UserName");
        String userName = scanner.next();

        System.out.println("Enter your Passkey");
        String password = scanner.next();

        System.out.println("Enter your Email");
        String email = scanner.next();

        System.out.println("Enter your Phone Number");
        String phoneNumber = scanner.next();

        System.out.println("Enter your Card Number");
        String cardNumber = scanner.next();

        customerService.registerCustomer(userName,password,email,phoneNumber,cardNumber);
        customerClientMainPage(userName);
    }


    /**
     * Prints a list of available slots.
     * @param slots The list of slots to print.
     */
    private void printSlots(List<FlipFitSlot> slots){
        System.out.println(DASHED_LINE);
        System.out.printf(YELLOW_COLOR + "%-8s\t", "SLOT-ID");
        System.out.printf("%-8s\t\n", "SLOT-TIME" + RESET_COLOR);
        System.out.println(DASHED_LINE);
        for(FlipFitSlot slot: slots) {
            System.out.printf("%-8s\t", slot.getSlotId());
            System.out.printf("%-8s\t\n", slot.getTime());
        }
        System.out.println(DASHED_LINE);
    }

    /**
     * Displays submenu for booking a slot.
     * @param userName The username of the customer booking the slot.
     */
    private void bookSlotSubMenu(String userName){
        //Get Location for filter
        System.out.println("Provide Location to search :");
        String location = scanner.next();
        List<FlipFitCenter> centreListByLocation = customerService.getAllGymCenterDetailsByCity(location);
        // Print All Centres
        FlipFitUtils.printGymCentres(centreListByLocation);
        //Select Gym Centre
        if(centreListByLocation.isEmpty()){
            System.out.println(RED_COLOR +"There are no available GYM Centres in " + location + ". Please Select some other location" + RESET_COLOR);
            bookSlotSubMenu(userName);
            return;
        }
        System.out.print("Choose a gymCentre ID to proceed:");
        String chosenGym = scanner.next();
        //Select Date
        Date sqlDate = selectDate();
        //Choose Slot
        chooseSlot(chosenGym,userName,sqlDate,chosenGym);
    }

    /**
     * Selects a date from user input.
     * @return The selected date as java.sql.Date.
     */
    private Date selectDate(){
        //Select Date
        System.out.print("Enter Date (dd/MM/yyyy): ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        Date sqlDate = null;
        try {
            String dat = scanner.next();
//            if(Validators.isDateValid(dat)){
//                date = sdf.parse(dat);
//                sqlDate = new Date(date.getTime());
//            }
//            else{
//                new DataEntryException();
//                sqlDate = selectDate();
//            }
            date = sdf.parse(dat);
            sqlDate = new Date(date.getTime());
        } catch (ParseException e) {
            throw new DataEntryException();
        }
        return sqlDate;
    }

    /**
     * Displays submenu for choosing a slot.
     * @param gymCentreId The ID of the gym center.
     * @param userName The username of the customer booking the slot.
     * @param sqlDate The selected date in SQL Date format.
     * @param centreId The ID of the gym center.
     */
    private void chooseSlot(String gymCentreId,String userName,Date sqlDate,String centreId){
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


    /**
     * Prints user plan details.
     * @param userName The username of the customer.
     */
    private void printUserPlan(String userName){
        System.out.println("Bookings : ");
        List<UserPlan> allUserPlan= customerService.getCustomerPlan(userName);
        List<FlipFitBooking> bookingList = customerService.getCustomerBookings(userName);
        System.out.println(DASHED_LINE);
        System.out.printf(YELLOW_COLOR + "%-8s\t", "Centre-ID");
        System.out.printf(YELLOW_COLOR + "%-8s\t", "SLOT-ID");
        System.out.printf(YELLOW_COLOR + "%-8s\t", "DATE");
        System.out.printf(YELLOW_COLOR + "%8s\t", "SLOT-TIME");
        System.out.printf("%-8s\t\n", "SCHEDULE_ID" + RESET_COLOR);
        System.out.println(DASHED_LINE);
        for(UserPlan userPlan: allUserPlan) {
            System.out.printf("%-8s\t", userPlan.getCenterID());
            System.out.printf("%-8s\t", userPlan.getSlotId());
            System.out.printf("%-8s\t", userPlan.getDate());
            System.out.printf("%-8s\t", userPlan.getTime());
            System.out.printf("%-8s\t\n", userPlan.getScheduleID());
        }
        System.out.println(DASHED_LINE);
    }

    /**
     * Prints bookings submenu.
     * @param userName The username of the customer.
     */
    private void printbookingsSubMenu(String userName){
        System.out.println("Bookings : ");
        List<FlipFitBooking> allBookingList= customerService.getCustomerBookings(userName);
        System.out.println(DASHED_LINE);
        System.out.printf(YELLOW_COLOR + "%-8s\t", "BOOKING-ID");
        System.out.printf("%47s\t\n", "SCHEDULE-ID" + RESET_COLOR);
        System.out.println(DASHED_LINE);
        for(FlipFitBooking booking: allBookingList) {
            System.out.printf("%-8s\t", booking.getBookingID());
            System.out.printf("%-8s\t\n", booking.getScheduleID());
        }
        System.out.println(DASHED_LINE);
    }


    /**
     * Cancels a booking based on user input.
     * @param userName The username of the customer cancelling the booking.
     */
    private void cancelBookingSubMenu(String userName){
        System.out.println("Select the Booking you want to cancel: ");
        printbookingsSubMenu(userName);
        String bookingId = scanner.next();
        customerService.cancelBookingbyID(bookingId);

    }

    /**
     * Prints customer profile details.
     * @param customer The customer object containing profile details.
     */
    public void printCustomerProfile(FlipFitCustomer customer){
        System.out.println(GREEN_COLOR +"------------------------------------------------------------------------" + RESET_COLOR);
        System.out.println(YELLOW_COLOR + "USER ID: "+ RESET_COLOR + customer.getUserId());
        System.out.println(YELLOW_COLOR + "USER NAME: "+ RESET_COLOR + customer.getUserName());
        System.out.println(YELLOW_COLOR + "EMAIL: "+ RESET_COLOR + customer.getEmailId());
        System.out.println(YELLOW_COLOR + "CONTACT: "+ RESET_COLOR + customer.getCustomerPhone());
        System.out.println(YELLOW_COLOR + "CARD DETAILS: "+ RESET_COLOR + customer.getCardDetails());
        System.out.println(GREEN_COLOR +"------------------------------------------------------------------------" + RESET_COLOR);
    }


    /**
     * Displays the main customer menu and processes user input.
     * @param userName The username of the logged-in customer.
     */
    public void customerClientMainPage(String userName) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = currentTime.format(myFormat);
        System.out.println(YELLOW_COLOR+"WELCOME "+userName+" !!\nWhat you what to do\nLogin TIME: "+currentTime+RESET_COLOR);
        while(true){
            System.out.println("1. View My Profile \n2. Book a slot in a Gym \n3. View Bookings\n4. Cancel Bookings\n5. Go Back to previous menu");
            int choice = scanner.nextInt();
            switch(choice){
                case 1:
                    FlipFitCustomer customer= customerService.viewMyProfile(userName);
                    printCustomerProfile(customer);
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
                    System.out.println(PREVIOUS_MENU_MESSAGE);
                    return;
                default:
                    System.out.println(INVALID_CHOICE_ERROR);
                    break;
            }
        }
    }

}