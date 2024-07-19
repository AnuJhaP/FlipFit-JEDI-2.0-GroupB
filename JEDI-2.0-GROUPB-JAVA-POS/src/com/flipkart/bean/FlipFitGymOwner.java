package com.flipkart.bean;

public class FlipFitGymOwner extends FlipFitUser {
    private String AccountNo;
    private String IFSCCode;
    private String OwnerId;

    public String getPAN() {
        return PAN;
    }

    public void setPAN(String PAN) {
        this.PAN = PAN;
    }

    private String PAN;

    public String getAadharNo() {
        return AadharNo;
    }

    public void setAadharNo(String aadharNo) {
        AadharNo = aadharNo;
    }

    private String AadharNo;

    public String getGSTIN() {
        return GSTIN;
    }

    public void setGSTIN(String GSTIN) {
        this.GSTIN = GSTIN;
    }

    private String GSTIN;

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    private Boolean isApproved;

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


