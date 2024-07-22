package com.flipkart.business;

import com.flipkart.bean.FlipFitSlot;
import com.flipkart.bean.Schedule;

import java.sql.Date;
import java.util.List;

/**
 * @author JEDI-02
 * Interface for Schedule Service Operations
 *
 */

public interface ScheduleService {
    /**
     * Creates a schedule for a given date and slot ID.
     *
     * @param date   Date of the schedule
     * @param slotId ID of the slot associated with the schedule
     * @return The created Schedule object
     */
    Schedule createSchedule(Date date, String slotId);

    /**
     * Retrieves a schedule based on slot ID and date.
     *
     * @param slotId ID of the slot
     * @param date   Date of the schedule
     * @return The Schedule object matching the slot ID and date
     */
    Schedule getScheduleByDateAndSlotId(String SlotId, Date date);

    /**
     * Modifies a schedule identified by its ID.
     *
     * @param scheduleId ID of the schedule to modify
     * @param action     Action to perform on the schedule (e.g., increase or decrease availability)
     * @return true if the modification was successful, false otherwise
     */
    boolean modifySchedule(String scheduleId,int action);

    /**
     * Checks availability of schedules for a gym center on a specific date.
     *
     * @param centreID ID of the gym center
     * @param date     Date for which availability is checked
     * @return List of schedules representing availability
     */
    List<Schedule> checkAvailability(String centreID, Date date);

    /**
     * Retrieves all available slots for booking at a gym center on a specific date.
     *
     * @param centreID ID of the gym center
     * @param date     Date for which available slots are requested
     * @return List of available slots
     */
    List<FlipFitSlot> getAllAvailableSlotsByDate(String centreID, Date date);

    /**
     * Retrieves or creates a schedule for a given slot and date.
     *
     * @param slotId ID of the slot
     * @param date   Date for which the schedule is needed
     * @return The existing or newly created Schedule object
     */
    Schedule getOrCreateSchedule(String slotId, Date date);
}

