package com.flipkart.bean;

import java.util.List;

// FlipFitGymOwner class represents a gym owner in the FlipFit system, extending FlipFitUser
public class FlipFitGymOwner extends FlipFitUser {
    private String panNumber;          // PAN number of the gym owner
    private List<String> gymCentreIDs; // List of gym center IDs owned by the gym owner
    private String cardDetails;        // Card details of the gym owner (e.g., credit card information)
    private int isApproved;            // Approval status of the gym owner (0 or 1)

    // Constructor to initialize FlipFitGymOwner object with necessary details
    public FlipFitGymOwner(String id, String userName, String email, String password, String panNumber, String cardDetails) {
        super(id, userName, email, password, Role.GYMOWNER); // Call to superclass constructor (FlipFitUser) with specific role
        this.panNumber = panNumber;
        this.cardDetails = cardDetails;
        this.isApproved = 0; // Default approval status is set to 0
    }

    // Getter method for retrieving PAN number
    public String getPanNumber() {
        return panNumber;
    }

    // Setter method for updating PAN number
    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    // Getter method for retrieving approval status
    public int getIsApproved() {
        return isApproved;
    }

    // Setter method for updating approval status
    public void setIsApproved(int approved) {
        isApproved = approved;
    }

    // Getter method for retrieving list of gym center IDs
    public List<String> getGymCentreIDs() {
        return gymCentreIDs;
    }

    // Setter method for updating list of gym center IDs
    public void setGymCentreIDs(List<String> gymCentreIDs) {
        this.gymCentreIDs = gymCentreIDs;
    }

    // Method to add a gym center ID to the list
    public void addGymCentreId(String gymCentreId) {
        this.gymCentreIDs.add(gymCentreId);
    }

    // Getter method for retrieving gym owner's card details
    public String getCardDetails() {
        return cardDetails;
    }

    // Setter method for updating gym owner's card details
    public void setCardDetails(String cardDetails) {
        this.cardDetails = cardDetails;
    }
}