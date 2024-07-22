package com.flipkart.dao;

import com.flipkart.bean.FlipFitCenter;
import java.util.List;
public interface GymCentreInterfaceDAO {

    List<FlipFitCenter> getAllCentersByOwnerId(String gymOwnerId);
    FlipFitCenter getGymCentreByCenterId(String gymCentreId);
    void addGymCenter(FlipFitCenter centre);
    public List<FlipFitCenter> getPendingGymCenterList();
    public void validateGymCenter(String gymCentreId, int isApproved);
    public void sendCentreApprovalRequest(String gymCentreId);
    public List<FlipFitCenter> getGymCentreListByCity(String city);
}