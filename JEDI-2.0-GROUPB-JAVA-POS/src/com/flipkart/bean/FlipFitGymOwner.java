package com.flipkart.bean;

import java.util.List;

public class FlipFitGymOwner extends FlipFitUser {
    private String panNumber;
    private List<String> gymCentreIDs;
    private String cardDetails;
    private int isApproved;

    public int getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(int isApproved) {
        this.isApproved = isApproved;
    }

    public String getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(String cardDetails) {
        this.cardDetails = cardDetails;
    }

    public List<String> getGymCentreIDs() {
        return gymCentreIDs;
    }

    public void setGymCentreIDs(List<String> gymCentreIDs) {
        this.gymCentreIDs = gymCentreIDs;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public FlipFitGymOwner(String id, String userName, String email, String password, String panNumber, String cardDetails) {
        super(id,userName, email, password, Role.GYMOWNER);
        this.panNumber = panNumber;
        this.cardDetails = cardDetails;
        this.isApproved = 0;
    }





    //private Boolean isApproved;

//    public String getAccountNo(){
//        return AccountNo;
//    }
//    public String getIFSCCode(){
//        return IFSCCode;
//    }
//    public String getOwnerId(){
//        return OwnerId;
//    }
//
//    public void setAccountNo(String accountNo){
//        AccountNo = accountNo;
//    }
//    public void setIFSCCode(String IFSCCode){
//        this.IFSCCode = IFSCCode;
//    }
//    public void setOwnerId(String ownerId){
//        OwnerId = ownerId;
//    }

}


