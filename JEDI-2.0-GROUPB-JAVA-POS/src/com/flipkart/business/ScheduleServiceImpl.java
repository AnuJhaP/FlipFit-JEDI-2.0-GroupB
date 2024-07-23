package com.flipkart.business;

import com.flipkart.bean.FlipFitSlot;
import com.flipkart.bean.Schedule;
import com.flipkart.dao.ScheduleDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JEDI-02
 * Service implementation for Scheduling Operations
 *
 */

public class ScheduleServiceImpl implements ScheduleService {


    private GymCenterService gymCentreService = new GymCenterServiceImpl();
    private SlotServiceImpl slotService = new SlotServiceImpl();
    private ScheduleDAO scheduleDAO = new ScheduleDAO();

    /**
     * Creates a new schedule for a given date and slot ID.
     *
     * @param date   Date of the schedule
     * @param slotId ID of the slot associated with the schedule
     * @return The created Schedule object
     */
    public Schedule createSchedule(Date date, String slotId){
        String centreID = slotService.getSlotByID(slotId).getCenterId();
        int availability = gymCentreService.getGymCentreById(centreID).getCapacity();
        Schedule schedule = new Schedule( date, slotId, availability);
        scheduleDAO.addSchedule(schedule);

        return schedule;
    }

    /**
     * Retrieves a schedule based on slot ID and date.
     *
     * @param SlotId ID of the slot
     * @param date   Date of the schedule
     * @return The Schedule object matching the slot ID and date, or null if not found
     */
    public Schedule getScheduleByDateAndSlotId(String SlotId, Date date){
        List<Schedule> scheduleList = scheduleDAO.getAllScheduleByDate(date);
        for(Schedule schedule: scheduleList){
            if(schedule.getSlotID().equals(SlotId))
                return schedule;
        }

        return null;
    }

    /**
     * Modifies a schedule identified by its ID.
     *
     * @param scheduleId ID of the schedule to modify
     * @param action     Action to perform on the schedule (e.g., increase or decrease availability)
     * @return true if the modification was successful, false otherwise
     */
    public boolean modifySchedule(String scheduleId,int action){
        return scheduleDAO.modifySchedule(scheduleId, action);
    }

    /**
     * Checks availability of schedules for a gym center on a specific date.
     *
     * @param centreID ID of the gym center
     * @param date     Date for which availability is checked
     * @return List of schedules representing availability
     */
    public List<Schedule> checkAvailability(String centreID, Date date){
        List<FlipFitSlot> allSlotsForGym = slotService.getAllSlotsByCentre(centreID);
        List<Schedule> allAvailableSchedules = new ArrayList<>();
        for(FlipFitSlot slot : allSlotsForGym){
            String slotId = slot.getSlotId();
            Schedule schedule = getOrCreateSchedule(slotId, date);
            if(schedule.getAvailability() > 0)
                allAvailableSchedules.add(schedule);
        }

        return allAvailableSchedules;
    }

    /**
     * Retrieves all available slots for booking at a gym center on a specific date.
     *
     * @param centreID ID of the gym center
     * @param date     Date for which available slots are requested
     * @return List of available slots
     */
    public List<FlipFitSlot> getAllAvailableSlotsByDate(String centreID, Date date) {
        List<FlipFitSlot> allSlotsOfThatCentre = slotService.getAllSlotsByCentre(centreID);
        List<FlipFitSlot> response = slotService.getAllSlotsByCentre(centreID);
        for(FlipFitSlot slot: allSlotsOfThatCentre){
            for(Schedule schedule: scheduleDAO.getAllScheduleByDate(date)){
                if (slotService.getSlotByID(schedule.getSlotID()).getCenterId().equals(centreID)){
                    if(schedule.getAvailability() <= 0){
                        response.remove(slot);
                    }
                }
            }
        }
        return response;
    }

    /**
     * Retrieves a schedule based on its ID.
     *
     * @param scheduleID ID of the schedule
     * @return The Schedule object with the specified ID
     */
    public Schedule getSchedule(String scheduleID){
        return scheduleDAO.getSchedule(scheduleID);
    }

    /**
     * Retrieves or creates a schedule for a given slot and date.
     *
     * @param slotId ID of the slot
     * @param date   Date for which the schedule is needed
     * @return The existing or newly created Schedule object
     */
    public Schedule getOrCreateSchedule(String slotId, Date date) {
        Schedule schedule = getScheduleByDateAndSlotId(slotId, date);
        if( schedule == null ){
            return createSchedule(date,slotId);
        }
        return schedule;

    }

}
