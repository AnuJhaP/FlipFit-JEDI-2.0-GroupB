package com.flipkart.business;

import com.flipkart.dao.GymOwnerDAO;

import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

/**
 * @author JEDI-02
 * Service implementation for Gym Owner Operations
 *
 */

public class GymOwnerServiceImpl implements GymOwnerService {
    private static GymOwnerDAO gymOwnerDAO = new GymOwnerDAO();

    /**
     * Requests approval for a gym owner.
     *
     * @param gymOwnerId ID of the gym owner to request approval for
     */
    public void requestGymOwnerApproval(String gymOwnerId) {
        gymOwnerDAO.sendOwnerApprovalRequest(gymOwnerId);
    }

    /**
     * Retrieves a list of all gym owners.
     *
     * @return List of all gym owners
     */
    public List<FlipFitGymOwner> viewAllGymOwners() {
        return gymOwnerDAO.getGymOwnerList();
    }

    /**
     * Authenticates a gym owner based on username and password.
     *
     * @param username Username of the gym owner
     * @param password Password of the gym owner
     * @return true if login is successful, false otherwise
     */
    public boolean loginGymOwner(String username,String password){
        return gymOwnerDAO.loginGymOwner(username,password);
    }

    /**
     * Registers a new gym owner with the provided details.
     *
     * @param userId     User ID of the gym owner
     * @param userName   Username of the gym owner
     * @param password   Password of the gym owner
     * @param email      Email of the gym owner
     * @param panNumber  PAN number of the gym owner
     * @param cardNumber Card number of the gym owner
     */
    public void registerGymOwner(String userId,String userName, String password, String email, String panNumber,String cardNumber) {
        gymOwnerDAO.registerGymOwner(new FlipFitGymOwner(userId,userName,email,password,panNumber,cardNumber));
    }
}