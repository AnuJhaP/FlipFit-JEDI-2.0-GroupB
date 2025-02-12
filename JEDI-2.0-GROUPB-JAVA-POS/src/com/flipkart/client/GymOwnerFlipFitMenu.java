package com.flipkart.client;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitSlot;
import com.flipkart.business.GymCenterServiceImpl;
import com.flipkart.business.GymOwnerService;
import com.flipkart.business.GymOwnerServiceImpl;
import com.flipkart.business.SlotServiceImpl;
import static com.flipkart.client.FlipFitApplicationClient.scanner;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import com.flipkart.utils.FlipFitUtils;
import com.flipkart.dao.GymOwnerDAO;
import com.flipkart.exceptions.LoginFailedException;


/**
 * @author JEDI-02
 * GymOwnerFlipFitMenu class handles operations for Gym Owners in FlipFit application.
 */
public class GymOwnerFlipFitMenu {
    GymOwnerDAO gymOwnerDAO = new GymOwnerDAO();
    private GymOwnerServiceImpl gymOwnerService = new GymOwnerServiceImpl();
    private SlotServiceImpl slotService = new SlotServiceImpl();
    private GymCenterServiceImpl gymCentreService = new GymCenterServiceImpl();



    /**
     * Handles the login process for Gym Owners.
     * @param userName Gym Owner's username
     * @param password Gym Owner's password
     * @return true if login is successful, false otherwise
     */
    public boolean gymOwnerLogin(String userName, String password) {
        if (gymOwnerService.loginGymOwner(userName,password)) {
            System.out.println("Successfully logged in");
            gymOwnerClientMainPage(userName);
        } else {
            new LoginFailedException("Gymowner Login Failed");
            return false;
        }
        return true;
    }

    /**
     * Handles the registration process for Gym Owners.
     */
    public void register() {
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

        gymOwnerService.registerGymOwner(userName,userName,password,email,panNumber,cardNumber);
        gymOwnerClientMainPage(userName);
    }


    /**
     * Displays the main menu for Gym Owners after successful login.
     * @param gymOwnerId Gym Owner's ID
     */
    public void gymOwnerClientMainPage(String gymOwnerId) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = currentTime.format(myFormat);
        System.out.println("WELCOME "+gymOwnerId+" !!\nWhat you what to do\nLogin TIME: "+currentTime);
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
                /* Take input from user for all service parameters ( Make the menu ) */

                case 0:
                    List<FlipFitCenter> allGymCentres = gymCentreService.getAllCentresByOwmerId(gymOwnerId);
                    FlipFitUtils.printGymCentres(allGymCentres);
                    break;

                case 1:
                    gymOwnerService.requestGymOwnerApproval(gymOwnerId);
                    break;

                case 2:

                    System.out.println("Enter gym centre id: ");
                    String gymId = scanner.next();

                    System.out.println("Enter Gym Centre name: ");
                    String gymCentreName = scanner.next();

                    System.out.println("Enter Gym Centre GSTIN: ");
                    String gstin = scanner.next();

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
                                    gstin,
                                    city,
                                    capacity,
                                    price
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

                    slotService.addSlotsForGym(centreId, newSlotList);
                    break;
                case 5:
                    System.out.println("PREVIOUS_MENU_MESSAGE");
                    return;
                default:
                    System.out.println("INVALID_CHOICE_ERROR");
                    break;
            }
        }
    }}