package com.flipkart.bean;

public class FlipFitGymOwner extends FlipFitUser {
    private String AccountNo;
    private String IFSCCode;
    private String OwnerId;

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


