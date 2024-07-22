package com.flipkart.bean;

import java.util.List;

public class FlipFitGymOwner extends FlipFitUser {
    private String panNumber;
    private List<String> gymCentreIDs;
    private String cardDetails;
    private int isApproved;

    public FlipFitGymOwner(String id,String userName, String email, String password, String panNumber, String cardDetails) {
        super(id,userName, email, password, Role.GYMOWNER);
        this.panNumber = panNumber;
        this.cardDetails = cardDetails;
        this.isApproved = 0;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public int getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(int approved) {
        isApproved = approved;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public List<String> getGymCentreIDs() {
        return gymCentreIDs;
    }

    public void setGymCenterIDs(List<String> gymCentreIDs) {
        this.gymCentreIDs = gymCentreIDs;
    }

    public void addGymCentreId(String gymCentreId) {
        this.gymCentreIDs.add(gymCentreId);
    }

    public String getCardDetails() { return cardDetails; }

    public void setCardDetails(String cardDetails) { this.cardDetails = cardDetails; }

}


