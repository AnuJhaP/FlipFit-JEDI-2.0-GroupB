package com.flipkart.business;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitSlot;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class GymCenterServiceImpl implements GymCenterService{

    @Override
    public boolean deleteGymCentre(int centreId) {
        return false;
    }

    @Override
    public List<FlipFitSlot> viewAvailableSlots(int centreId) {
        return List.of();
    }

    @Override
    public List<FlipFitCenter> getAllCentresByOwmerId(String gymOwnerId) {
        return List.of();
    }

    @Override
    public List<FlipFitCenter> getCentresByCity(String city) {
        return List.of();
    }

    @Override
    public List<FlipFitSlot> getAvailableSlotsByCentreAndDate(String centreID, Date date) {
        return List.of();
    }

    @Override
    public void addCenter(FlipFitCenter gymCentre) {

    }

    @Override
    public void requestGymCentreApproval(String gymCentreId) {

    }

    @Override
    public FlipFitCenter getGymCentreById(String centreID) {
        return null;
    }
}
