package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymOwner;
import java.util.List;

/**
 * GymOwnerInterfaceDAO interface defines methods for managing gym owners in the Flipkart system
 */
public interface GymOwnerInterfaceDAO {

    /**
     * Retrieves a list of all gym owners.
     *
     * @return List of FlipFitGymOwner objects representing all gym owners
     */
    public List<FlipFitGymOwner> getGymOwnerList();

    /**
     * Sets the list of gym owners.
     *
     * @param gymOwnerList List of FlipFitGymOwner objects to set as the gym owners
     */
    public void setGymOwnerList(List<FlipFitGymOwner> gymOwnerList);

    /**
     * Registers a new gym owner.
     *
     * @param gymOwner FlipFitGymOwner object representing the gym owner to register
     */
    public void registerGymOwner(FlipFitGymOwner gymOwner);

    /**
     * Retrieves a list of pending gym owners awaiting approval.
     *
     * @return List of FlipFitGymOwner objects representing pending gym owners
     */
    public List<FlipFitGymOwner> getPendingGymOwnerList();

    /**
     * Sends a request for approval of a gym owner identified by gymOwnerId.
     *
     * @param gymOwnerId ID of the gym owner to send approval request for
     */
    public void sendOwnerApprovalRequest(String gymOwnerId);

    /**
     * Sets the list of pending gym owners.
     */
    public void setPendingGymOwnerList();

    /**
     * Validates (approves or rejects) a gym owner identified by gymOwnerId.
     *
     * @param gymOwnerId ID of the gym owner to validate
     * @param isApproved Approval status (1 for approved, 0 for rejected)
     */
    public void validateGymOwner(String gymOwnerId, int isApproved);
}