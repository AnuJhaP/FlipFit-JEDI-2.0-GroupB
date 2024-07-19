package com.flipkart.dao;

import com.flipkart.bean.FlipFitCenter;

import java.util.List;

public interface GymCenterInterfaceDAO {

    List<FlipFitCenter> getAllCentresByOwmerId(String gymOwnerId);
    FlipFitCenter getGymCentreByCentreId(String gymCentreId);
    void addGymCentre(FlipFitCenter centre);
    public List<FlipFitCenter> getPendingGymCentreList();
    public void validateGymCentre(String gymCentreId, int isApproved);
    public void sendCentreApprovalRequest(String gymCentreId);
    public List<FlipFitCenter> getGymCentreListByCity(String city);
}