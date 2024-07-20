package com.flipkart.business;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitSlot;

import java.sql.Date;
import java.util.List;

import com.flipkart.dao.GymCentreDAO;
import com.flipkart.dao.GymCentreInterfaceDAO;

public class GymCenterServiceImpl implements GymCenterService{

    private static GymCentreInterfaceDAO gymCentreDAO = new GymCentreDAO();
    private static ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();

    public List<FlipFitCenter> getAllCentresByOwmerId(String gymOwnerId) {
        return gymCentreDAO.getAllCentresByOwnerId(gymOwnerId);
    }

    public List<FlipFitCenter> getCentresByCity(String city){
        return gymCentreDAO.getGymCentreListByCity(city);
    }

    @Override
    public List<FlipFitSlot> getAvailableSlotsByCentreAndDate(String centreID, Date date) {
        return scheduleService.getAllAvailableSlotsByDate(centreID, date);
    }


    public void addCenter(FlipFitCenter gymCentre) {
        gymCentreDAO.addGymCentre(gymCentre);

    }

    public void requestGymCentreApproval(String gymCentreId){
        gymCentreDAO.sendCentreApprovalRequest(gymCentreId);
    }

    public FlipFitCenter getGymCentreById(String centreID) {
        FlipFitCenter gymCentre = gymCentreDAO.getGymCentreByCentreId(centreID);
        return gymCentre;
    }
}