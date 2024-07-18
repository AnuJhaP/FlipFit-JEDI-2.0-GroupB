package com.flipkart.business;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitSlot;

import java.util.Date;
import java.util.List;


public interface GymCenterService {

    public boolean deleteGymCentre(int centreId);
    public List<FlipFitSlot> viewAvailableSlots(int centreId);
    List<FlipFitCenter> getAllCentresByOwmerId(String gymOwnerId);
    List<FlipFitCenter> getCentresByCity(String city);
    List<FlipFitSlot> getAvailableSlotsByCentreAndDate(String centreID, Date date);
    void addCenter(FlipFitCenter gymCentre);
    void requestGymCentreApproval(String gymCentreId);
    FlipFitCenter getGymCentreById(String centreID);
}
