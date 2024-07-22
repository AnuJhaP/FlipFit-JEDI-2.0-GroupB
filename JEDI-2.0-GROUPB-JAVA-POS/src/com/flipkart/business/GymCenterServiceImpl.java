package com.flipkart.business;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitSlot;

import java.sql.Date;
import java.util.List;

import com.flipkart.dao.GymCentreDAO;
import com.flipkart.dao.GymCentreInterfaceDAO;

/**
 * @author JEDI-02
 * Service implementation for Gym Center Operations
 *
 */

public class GymCenterServiceImpl implements GymCenterService{

    private static GymCentreInterfaceDAO gymCentreDAO = new GymCentreDAO();
    private static ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();

    /**
     * Retrieves all gym centers owned by a specified gym owner.
     *
     * @param gymOwnerId ID of the gym owner
     * @return List of gym centers owned by the gym owner
     */
    public List<FlipFitCenter> getAllCentresByOwmerId(String gymOwnerId) {
        return gymCentreDAO.getAllCentresByOwnerId(gymOwnerId);
    }

    /**
     * Retrieves gym centers located in a specified city.
     *
     * @param city City name
     * @return List of gym centers in the specified city
     */
    public List<FlipFitCenter> getCentresByCity(String city){
        return gymCentreDAO.getGymCentreListByCity(city);
    }

    /**
     * Retrieves available slots for booking at a specified gym center on a given date.
     *
     * @param centreID ID of the gym center
     * @param date     Date for which available slots are requested
     * @return List of available slots
     */
    @Override
    public List<FlipFitSlot> getAvailableSlotsByCentreAndDate(String centreID, Date date) {
        return scheduleService.getAllAvailableSlotsByDate(centreID, date);
    }

    /**
     * Adds a new gym center to the system.
     *
     * @param gymCentre Gym center to add
     */
    public void addCenter(FlipFitCenter gymCentre) {
        gymCentreDAO.addGymCentre(gymCentre);

    }

    /**
     * Requests approval for a gym center.
     *
     * @param gymCentreId ID of the gym center to request approval for
     */
    public void requestGymCentreApproval(String gymCentreId){
        gymCentreDAO.sendCentreApprovalRequest(gymCentreId);
    }

    /**
     * Retrieves details of a gym center based on its ID.
     *
     * @param centreID ID of the gym center
     * @return Gym center details
     */
    public FlipFitCenter getGymCentreById(String centreID) {
        FlipFitCenter gymCentre = gymCentreDAO.getGymCentreByCentreId(centreID);
        return gymCentre;
    }
}