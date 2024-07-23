package com.flipkart.dao;

import com.flipkart.bean.FlipFitCenter;
import java.util.List;

/**
 * GymCentreInterfaceDAO interface defines methods for managing gym centers in the Flipkart system
 */
public interface GymCentreInterfaceDAO {

    /**
     * Retrieves all gym centers owned by a specific owner identified by gymOwnerId.
     *
     * @param gymOwnerId ID of the gym owner whose gym centers are to be retrieved
     * @return List of FlipFitCenter objects representing the gym centers
     */
    List<FlipFitCenter> getAllCentresByOwnerId(String gymOwnerId);

    /**
     * Retrieves a gym center by its unique identifier gymCentreId.
     *
     * @param gymCentreId ID of the gym center to retrieve
     * @return FlipFitCenter object representing the gym center
     */
    FlipFitCenter getGymCentreByCentreId(String gymCentreId);

    /**
     * Adds a new gym center to the system.
     *
     * @param centre FlipFitCenter object representing the gym center to be added
     */
    void addGymCentre(FlipFitCenter centre);

    /**
     * Retrieves a list of pending gym centers awaiting approval.
     *
     * @return List of FlipFitCenter objects representing the pending gym centers
     */
    List<FlipFitCenter> getPendingGymCentreList();

    /**
     * Validates (approves or rejects) a gym center identified by gymCentreId.
     *
     * @param gymCentreId ID of the gym center to validate
     * @param isApproved  Approval status (1 for approved, 0 for rejected)
     */
    void validateGymCentre(String gymCentreId, int isApproved);

    /**
     * Sends a request for approval of a gym center identified by gymCentreId.
     *
     * @param gymCentreId ID of the gym center to send approval request for
     */
    void sendCentreApprovalRequest(String gymCentreId);

    /**
     * Retrieves a list of gym centers in a specific city identified by city.
     *
     * @param city Name of the city to retrieve gym centers from
     * @return List of FlipFitCenter objects representing the gym centers in the city
     */
    List<FlipFitCenter> getGymCentreListByCity(String city);
}
