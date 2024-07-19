package com.flipkart.bean;

public class FlipFitGymOwner extends FlipFitUser {
    private String AccountNo;
    private String IFSCCode;

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    private String panNumber;

    public FlipFitGymOwner(String ownerId, String name, String email, Boolean password,String panNumber) {
        super(ownerId,name, email, password, "GYMOWNER");
        this.panNumber = panNumber;
        this.isApproved = 0;
    }

    private String OwnerId;
    private Boolean isApproved;

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public String getAccountNo(){
        return AccountNo;
    }
    public String getIFSCCode(){
        return IFSCCode;
    }
    public String getOwnerId(){
        return OwnerId;
    }

    public void setAccountNo(String accountNo){
        AccountNo = accountNo;
    }
    public void setIFSCCode(String IFSCCode){
        this.IFSCCode = IFSCCode;
    }
    public void setOwnerId(String ownerId){
        OwnerId = ownerId;
    }

}


