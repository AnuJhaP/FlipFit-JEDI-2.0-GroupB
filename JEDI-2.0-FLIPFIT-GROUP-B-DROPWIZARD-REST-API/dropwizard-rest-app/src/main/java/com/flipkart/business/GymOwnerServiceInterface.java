package com.flipkart.business;

public interface GymOwnerServiceInterface {
    void requestGymOwnerApproval(String gymOwnerId);
    List<GymOwner> viewAllGymOwners();
    GymOwner loginGymOwner(String userId, String password);
    GymOwner registerGymOwner(GymOwner gymOwner);

}
