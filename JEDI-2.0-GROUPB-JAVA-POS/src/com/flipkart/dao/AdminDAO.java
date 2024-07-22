package com.flipkart.dao;
import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.exceptions.UserInvalidException;

import java.util.List;

/**
 * AdminDAO class implements AdminInterfaceDAO.
 * This class is responsible for handling admin-related data access operations.
 */

public class AdminDAO implements AdminInterfaceDAO {

    // Instances of DAO interfaces for GymOwner and GymCentre
    private static GymOwnerInterfaceDAO gymOwnerDAO = new GymOwnerDAO();
    private static GymCentreInterfaceDAO gymCentreDAO = new GymCentreDAO();

    /**
     * Retrieves the list of pending gym owners.
     *
     * @return List of FlipFitGymOwner objects that are pending approval.
     */
    public List<FlipFitGymOwner> getPendingGymOwners() {
        return gymOwnerDAO.getPendingGymOwnerList();
    }
    /**
     * Validates a gym owner based on their ID and approval status.
     *
     * @param gymOwnerId The ID of the gym owner to be validated.
     * @param isApproved The approval status (e.g., 1 for approved, 0 for not approved).
     */
    public void validateGymOwner(String gymOwnerId, int isApproved) {
        gymOwnerDAO.validateGymOwner(gymOwnerId, isApproved);
    }



    /**
     * Validates a gym centre based on its ID and approval status.
     *
     * @param gymCentreId The ID of the gym centre to be validated.
     * @param isApproved The approval status (e.g., 1 for approved, 0 for not approved).
     */
  
        public void validateGymCentre(String gymCentreId, int isApproved) {
            gymCentreDAO.validateGymCenter(gymCentreId,isApproved);
        }

       

        //admin returns true
        @Override
        public boolean isUserValid(String userName, String password)  {
            return true;
        }


    /**
     * Retrieves the list of pending gym centres.
     *
     * @return List of FlipFitCenter objects that are pending approval.
     */
    public List<FlipFitCenter> getPendingGymCentres() {
        return gymCentreDAO.getPendingGymCentreList();
    }

}
