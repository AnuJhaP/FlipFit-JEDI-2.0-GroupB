package com.flipkart.bean;

import java.util.List;

/**
 * FlipFitGymOwner class represents a gym owner entity in the FlipFit system,
 * extending FlipFitUser for user-related functionalities.
 */
public class FlipFitGymOwner extends FlipFitUser {
    private String panNumber;          // PAN number of the gym owner
    private List<String> gymCentreIDs; // List of gym center IDs owned by the gym owner
    private String cardDetails;        // Card details of the gym owner (e.g., credit card information)
    private int isApproved;            // Approval status of the gym owner (0 or 1)

    /**
     * Constructor to initialize a FlipFitGymOwner object with necessary details.
     *
     * @param id          The ID of the gym owner.
     * @param userName    The name of the gym owner.
     * @param email       The email address of the gym owner.
     * @param password    The password of the gym owner.
     * @param panNumber   The PAN number of the gym owner.
     * @param cardDetails The card details of the gym owner.
     */
    public FlipFitGymOwner(String id, String userName, String email, String password, String panNumber, String cardDetails) {
        super(id, userName, email, password, Role.GYMOWNER); // Call to superclass constructor (FlipFitUser) with specific role
        this.panNumber = panNumber;
        this.cardDetails = cardDetails;
        this.isApproved = 0; // Default approval status is set to 0
    }

    /**
     * Getter method to retrieve the PAN number of the gym owner.
     *
     * @return The PAN number of the gym owner.
     */
    public String getPanNumber() {
        return panNumber;
    }

    /**
     * Setter method to update the PAN number of the gym owner.
     *
     * @param panNumber The new PAN number of the gym owner to be set.
     */
    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    /**
     * Getter method to retrieve the approval status of the gym owner.
     *
     * @return The approval status of the gym owner (0 or 1).
     */
    public int getIsApproved() {
        return isApproved;
    }

    /**
     * Setter method to update the approval status of the gym owner.
     *
     * @param approved The new approval status of the gym owner to be set (0 or 1).
     */
    public void setIsApproved(int approved) {
        isApproved = approved;
    }

    /**
     * Getter method to retrieve the list of gym center IDs owned by the gym owner.
     *
     * @return The list of gym center IDs owned by the gym owner.
     */
    public List<String> getGymCentreIDs() {
        return gymCentreIDs;
    }

    /**
     * Setter method to update the list of gym center IDs owned by the gym owner.
     *
     * @param gymCentreIDs The new list of gym center IDs to be set.
     */
    public void setGymCentreIDs(List<String> gymCentreIDs) {
        this.gymCentreIDs = gymCentreIDs;
    }

    /**
     * Method to add a gym center ID to the list owned by the gym owner.
     *
     * @param gymCentreId The gym center ID to be added to the list.
     */
    public void addGymCentreId(String gymCentreId) {
        this.gymCentreIDs.add(gymCentreId);
    }

    /**
     * Getter method to retrieve the card details of the gym owner.
     *
     * @return The card details of the gym owner.
     */
    public String getCardDetails() {
        return cardDetails;
    }

    /**
     * Setter method to update the card details of the gym owner.
     *
     * @param cardDetails The new card details of the gym owner to be set.
     */
    public void setCardDetails(String cardDetails) {
        this.cardDetails = cardDetails;
    }
}