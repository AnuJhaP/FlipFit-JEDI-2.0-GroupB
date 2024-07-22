package com.flipkart.business;

import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

/**
 * @author JEDI-02
 * Interface for Gym Owner Service Operations
 *
 */

public interface GymOwnerService {

    /**
     * Requests approval for a gym owner.
     *
     * @param gymOwnerId ID of the gym owner to request approval for
     */
    void requestGymOwnerApproval(String gymOwnerId);

    /**
     * Retrieves a list of all gym owners.
     *
     * @return List of all gym owners
     */
    List<FlipFitGymOwner> viewAllGymOwners();

    /**
     * Authenticates a gym owner based on user ID and password.
     *
     * @param userId   User ID of the gym owner
     * @param password Password of the gym owner
     * @return true if login is successful, false otherwise
     */
    boolean loginGymOwner(String userId, String password);

    /**
     * Registers a new gym owner with the provided details.
     *
     * @param userId    User ID of the gym owner
     * @param userName  Username of the gym owner
     * @param password  Password of the gym owner
     * @param email     Email of the gym owner
     * @param panNumber PAN number of the gym owner
     * @param cardNumber Card number of the gym owner
     */
    void registerGymOwner(String userId,String userName, String password, String email, String panNumber,String cardNumber);
}
