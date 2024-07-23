package com.flipkart.business;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

/**
 * @author JEDI-02
 * Interface for Admin Service Operations
 *
 */

public interface AdminService {

    /**
     * Validates a gym center based on its ID and approval status.
     *
     * @param centerId   ID of the gym center to validate
     * @param isApproved Approval status (1 for approved, 0 for not approved)
     */
    void validateCenter(String centerId, int isApproved);

    /**
     * Validates a gym owner based on their ID and approval status.
     *
     * @param ownerId   ID of the gym owner to validate
     * @param isApproved Approval status (1 for approved, 0 for not approved)
     */
    void validateOwner(String ownerId, int isApproved);

    /**
     * Retrieves and returns a list of pending gym centers awaiting validation.
     *
     * @return List of pending gym centers
     */
    List<FlipFitCenter> viewPendingCentres();

    /**
     * Retrieves and returns a list of pending gym owners awaiting validation.
     *
     * @return List of pending gym owners
     */
    List<FlipFitGymOwner> viewPendingOwners();

    /** Function to check validity of user
     * @param userName name of user
     * @param password passowrd of user
     * @return boolean
     */
    boolean isUserValid(String userName, String password);

}
