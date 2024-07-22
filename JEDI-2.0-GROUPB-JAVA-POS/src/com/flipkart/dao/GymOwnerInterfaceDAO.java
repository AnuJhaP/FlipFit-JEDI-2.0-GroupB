package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymOwner;
import java.util.List;

// GymOwnerInterfaceDAO interface defines methods for managing gym owners in the Flipkart system
public interface GymOwnerInterfaceDAO {

    // Method to retrieve a list of all gym owners
    public List<FlipFitGymOwner> getGymOwnerList();

    // Method to set the list of gym owners
    public void setGymOwnerList(List<FlipFitGymOwner> gymOwnerList);

    // Method to register a new gym owner
    public void registerGymOwner(FlipFitGymOwner gymOwner);

    // Method to retrieve a list of pending gym owners awaiting approval
    public List<FlipFitGymOwner> getPendingGymOwnerList();

    // Method to send a request for approval of a gym owner identified by gymOwnerId
    public void sendOwnerApprovalRequest(String gymOwnerId);

    // Method to set the list of pending gym owners
    public void setPendingGymOwnerList();

    // Method to validate (approve/reject) a gym owner identified by gymOwnerId
    public void validateGymOwner(String gymOwnerId, int isApproved);
}
