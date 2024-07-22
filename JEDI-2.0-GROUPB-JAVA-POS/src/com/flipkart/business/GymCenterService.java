package com.flipkart.business;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitSlot;

import java.sql.Date;
import java.util.List;

/**
 * @author JEDI-02
 * Interface for Gym Center Service Operations
 *
 */

public interface GymCenterService {

    /**
     * Retrieves all gym centers owned by a specified gym owner.
     *
     * @param gymOwnerId ID of the gym owner
     * @return List of gym centers owned by the gym owner
     */
    List<FlipFitCenter> getAllCentresByOwmerId(String gymOwnerId);

    /**
     * Retrieves gym centers located in a specified city.
     *
     * @param city City name
     * @return List of gym centers in the specified city
     */
    List<FlipFitCenter> getCentresByCity(String city);

    /**
     * Retrieves available slots for booking at a specified gym center on a given date.
     *
     * @param centreID ID of the gym center
     * @param date     Date for which available slots are requested
     * @return List of available slots
     */
    List<FlipFitSlot> getAvailableSlotsByCentreAndDate(String centreID, Date date);

    /**
     * Adds a new gym center to the system.
     *
     * @param gymCentre Gym center to add
     */
    void addCenter(FlipFitCenter gymCentre);

    /**
     * Requests approval for a gym center.
     *
     * @param gymCentreId ID of the gym center to request approval for
     */
    void requestGymCentreApproval(String gymCentreId);

    /**
     * Retrieves details of a gym center based on its ID.
     *
     * @param centreID ID of the gym center
     * @return Gym center details
     */

    FlipFitCenter getGymCentreById(String centreID);
//     List<FlipFitSlot> getAvailableSlotsByCenterAndDate(String centreID, Date date);
}

