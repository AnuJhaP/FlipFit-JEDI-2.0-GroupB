package com.flipkart.business;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitSlot;

import java.sql.Date;
import java.util.List;


public interface GymCenterService {

    List<FlipFitCenter> getAllCentresByOwmerId(String gymOwnerId);
    List<FlipFitCenter> getCentresByCity(String city);
    List<FlipFitSlot> getAvailableSlotsByCentreAndDate(String centreID, Date date);
    void addCenter(FlipFitCenter gymCentre);
    void requestGymCentreApproval(String gymCentreId);
    FlipFitCenter getGymCentreById(String centreID);
//     List<FlipFitSlot> getAvailableSlotsByCenterAndDate(String centreID, Date date);
}

