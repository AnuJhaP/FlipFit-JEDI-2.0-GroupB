package com.flipkart.business;

public interface AdminServiceInterface {
    public void approveGymCenter(String gymCentreId,int isApproved);
    void approveGymOwner(String gymOwnerId,int isApprove);
    List<GymCentre> viewPendingGymCentres();
    List<GymOwner> viewPendingGymOwners();

}
