package com.flipkart.dao;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.exceptions.UserInvalidException;

import java.util.List;

// AdminInterfaceDAO interface defines methods for admin operations related to gym owners and gym centers
public interface AdminInterfaceDAO {

    // Method to retrieve a list of pending gym owners awaiting validation
    public List<FlipFitGymOwner> getPendingGymOwners();

    // Method to validate a gym owner by setting approval status
    public void validateGymOwner(String gymOwnerId, int isApproved);

    // Method to validate a gym center by setting approval status
    public void validateGymCentre(String gymCentreId, int isApproved);

    // Method to retrieve a list of pending gym centers awaiting validation
    public List<FlipFitCenter> getPendingGymCentres();
    public boolean isUserValid(String userName, String password);

}
