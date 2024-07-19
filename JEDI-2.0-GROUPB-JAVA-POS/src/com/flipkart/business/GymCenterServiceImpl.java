package com.flipkart.business;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitSlot;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;

//public class GymCenterServiceImpl implements GymCenterService{
//
//
//    private static ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();
//
//    public List<FlipFitCenter> getAllCentresByOwmerId(String gymOwnerId) {
//        return gymCentreDAO.getAllCentresByOwmerId(gymOwnerId);
//    }
//
//    public List<FlipFitCenter> getCentresByCity(String city){
//        return gymCentreDAO.getGymCentreListByCity(city);
//    }
//
//    public List<FlipFitSlot> getAvailableSlotsByCentreAndDate(String centreID, Date date){
//        return scheduleService.getAllAvailableSlotsByDate(centreID, date);
//    }
//
//    public void addCenter(FlipFitCenter gymCentre) {
//        gymCentreDAO.addGymCentre(gymCentre);
//
//    }
//
//    public void requestGymCentreApproval(String gymCentreId){
//        gymCentreDAO.sendCentreApprovalRequest(gymCentreId);
//    }
//
//    public FlipFitCenter getGymCentreById(String centreID) {
//        FlipFitCenter gymCentre = gymCentreDAO.getGymCentreByCentreId(centreID);
//        return gymCentre;
//    }
public class GymCenterServiceImpl implements GymCenterService {
    // Assume in-memory storage instead of DAO
    private HashMap<String, FlipFitCenter> gymCentreMap = new HashMap<>();

    public List<FlipFitCenter> getAllCentresByOwnerId(String gymOwnerId) {
        // Logic to fetch centres by owner ID from in-memory map
        List<FlipFitCenter> centres = new ArrayList<>();
        for (FlipFitCenter centre : gymCentreMap.values()) {
            if (centre.getOwnerID().equals(gymOwnerId)) {
                centres.add(centre);
            }
        }
        return centres;
    }

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

    public List<FlipFitCenter> getCentresByCity(String city) {
        // Logic to fetch centres by city from in-memory map
        List<FlipFitCenter> centres = new ArrayList<>();
        for (FlipFitCenter centre : gymCentreMap.values()) {
            if (centre.getCity().equalsIgnoreCase(city)) {
                centres.add(centre);
            }
        }
        return centres;
    }

    @Override
    public List<FlipFitSlot> getAvailableSlotsByCentreAndDate(String centreID, Date date) {
        return List.of();
    }

    public void addCenter(FlipFitCenter gymCentre) {
        // Add centre to in-memory map
        gymCentreMap.put(gymCentre.getGymCentreID(), gymCentre);
    }

    public void requestGymCentreApproval(String gymCentreId) {
        FlipFitCenter centre = gymCentreMap.get(gymCentreId);
        if (centre != null) {
//            centre.setStatus("Pending Approval");
            gymCentreMap.put(gymCentreId, centre);
        }
    }

    public FlipFitCenter getGymCentreById(String centreID) {
        return gymCentreMap.get(centreID);
    }

}
