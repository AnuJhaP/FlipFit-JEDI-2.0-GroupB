package com.flipkart.dao;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.exceptions.UserInvalidException;

import java.util.List;

/**
 * AdminInterfaceDAO interface defines methods for admin operations related to gym owners and gym centers.
 * These methods include retrieving pending gym owners and gym centers, as well as validating them by setting approval status.
 */
public interface AdminInterfaceDAO {

    /**
     * Method to retrieve a list of pending gym owners awaiting validation.
     *
     * @return List of FlipFitGymOwner objects representing pending gym owners
     */
    public List<FlipFitGymOwner> getPendingGymOwners();

    /**
     * Method to validate a gym owner by setting approval status.
     *
     * @param gymOwnerId ID of the gym owner to validate
     * @param isApproved Approval status (0 for not approved, 1 for approved)
     */
    public void validateGymOwner(String gymOwnerId, int isApproved);

    /**
     * Method to validate a gym center by setting approval status.
     *
     * @param gymCentreId ID of the gym center to validate
     * @param isApproved Approval status (0 for not approved, 1 for approved)
     */
    public void validateGymCentre(String gymCentreId, int isApproved);

    /**
     * Method to retrieve a list of pending gym centers awaiting validation.
     *
     * @return List of FlipFitCenter objects representing pending gym centers
     */
    public List<FlipFitCenter> getPendingGymCentres();
    public boolean isUserValid(String userName, String password);

}
