package com.flipkart.dao;

import com.flipkart.bean.FlipFitCenter;
import java.util.List;

// GymCentreInterfaceDAO interface defines methods for managing gym centers in the Flipkart system
public interface GymCentreInterfaceDAO {


    // Method to retrieve all gym centers owned by a specific owner identified by gymOwnerId
    List<FlipFitCenter> getAllCentresByOwnerId(String gymOwnerId);

    // Method to retrieve a gym center by its unique identifier gymCentreId
    FlipFitCenter getGymCentreByCentreId(String gymCentreId);

    // Method to add a new gym center to the system
    void addGymCentre(FlipFitCenter centre);

    // Method to retrieve a list of pending gym centers awaiting approval
    List<FlipFitCenter> getPendingGymCentreList();

    // Method to validate (approve/reject) a gym center identified by gymCentreId
    void validateGymCentre(String gymCentreId, int isApproved);

    // Method to send a request for approval of a gym center identified by gymCentreId
    void sendCentreApprovalRequest(String gymCentreId);

    // Method to retrieve a list of gym centers in a specific city identified by city
    List<FlipFitCenter> getGymCentreListByCity(String city);
}

