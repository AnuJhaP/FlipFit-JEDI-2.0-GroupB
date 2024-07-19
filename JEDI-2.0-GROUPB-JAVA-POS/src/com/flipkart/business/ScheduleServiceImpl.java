package com.flipkart.business;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitSlot;
import com.flipkart.bean.Schedule;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//public class ScheduleServiceImpl implements ScheduleService {
//
//    private GymCenterServiceImpl gymCentreService = new GymCenterServiceImpl();
//    private SlotServiceImpl slotService = new SlotServiceImpl();
//
//    public Schedule createSchedule(Date date, String slotId){
//        String centreID = slotService.getSlotByID(slotId).getCenterId();
//        int availability = gymCentreService.getGymCentreById(centreID).getCapacity();
//        Schedule schedule = new Schedule( date, slotId, availability);
//        scheduleDAO.addSchedule(schedule);
//
//        return schedule;
//    }
//
//    public Schedule getScheduleByDateAndSlotId(String SlotId, Date date){
//        //returns whether current schedule exists or not
//        List<Schedule> scheduleList = scheduleDAO.getAllScheduleByDate(date);
//        for(Schedule schedule: scheduleList){
//            if(schedule.getSlotID().equals(SlotId))
//                return schedule;
//        }
//
//        //Schedule doesn't exist, return null
//        return null;
//    }
//
//    public boolean modifySchedule(String scheduleId,int action){
//        // increment or decrement availability based on action
//        // 1 for increasing availability, -1 for decreasing
//        return scheduleDAO.modifySchedule(scheduleId, action);
//    }
//
//    public List<Schedule> checkAvailability(String centreID, Date date){
//        List<FlipFitSlot> allSlotsForGym = slotService.getAllSlotsByCentre(centreID);
//        List<Schedule> allAvailableSchedules = new ArrayList<>();
//        for(FlipFitSlot slot : allSlotsForGym){
//            String slotId = slot.getSlotId();
//            Schedule schedule = getOrCreateSchedule(slotId, date);
//            if(schedule.getAvailability() > 0)
//                allAvailableSchedules.add(schedule);
//        }
//
//        return allAvailableSchedules;
//    }
//
//    public List<FlipFitSlot> getAllAvailableSlotsByDate(String centreID, Date date) {
//        List<FlipFitSlot> allSlotsOfThatCentre = slotService.getAllSlotsByCentre(centreID);
//        List<FlipFitSlot> response = slotService.getAllSlotsByCentre(centreID);
//        for(FlipFitSlot slot: allSlotsOfThatCentre){
//            for(Schedule schedule: scheduleDAO.getAllScheduleByDate(date)){
//                if (slotService.getSlotByID(schedule.getSlotID()).getCenterId().equals(centreID)){
//                    if(schedule.getAvailability() <= 0){
//                        response.remove(slot);
//                    }
//                }
//            }
//        }
//        return response;
//    }
//
//    public Schedule getSchedule(String scheduleID){
//        return scheduleDAO.getSchedule(scheduleID);
//    }
//
//    public Schedule getOrCreateSchedule(String slotId, Date date) {
//        Schedule schedule = getScheduleByDateAndSlotId(slotId, date);
//        if( schedule == null ){
//            return createSchedule(date,slotId);
//        }
//        return schedule;
//
//    }
//}
public class ScheduleServiceImpl implements ScheduleService {

    private HashMap<String, Schedule> schedules = new HashMap<>();
    private GymCenterServiceImpl gymCentreService = new GymCenterServiceImpl();
    private SlotServiceImpl slotService = new SlotServiceImpl();

    public Schedule createSchedule(Date date, String slotId) {
        FlipFitSlot slot = slotService.getSlotByID(slotId);
        if (slot == null) {
            return null; // Slot not found
        }
        String centreID = slot.getCenterId();
        FlipFitCenter gymCentre = gymCentreService.getGymCentreById(centreID);
        if (gymCentre == null) {
            return null; // Gym center not found
        }

        int availability = gymCentre.getCapacity();
        Schedule schedule = new Schedule(date, slotId, availability);
        schedules.put(schedule.getScheduleID(), schedule); // Store in-memory

        return schedule;
    }

    public Schedule getScheduleByDateAndSlotId(String slotId, Date date) {
        for (Schedule schedule : schedules.values()) {
            if (schedule.getSlotID().equals(slotId) && schedule.getDate().equals(date)) {
                return schedule;
            }
        }
        return null; // Schedule not found
    }

    public boolean modifySchedule(String scheduleId, int action) {
        Schedule schedule = schedules.get(scheduleId);
        if (schedule == null) {
            return false; // Schedule not found
        }
        int newAvailability = schedule.getAvailability() + action;
        if (newAvailability < 0) {
            return false; // Invalid action
        }
        schedule.setAvailability(newAvailability);
        schedules.put(scheduleId, schedule); // Update in-memory
        return true;
    }

    public List<Schedule> checkAvailability(String centreID, Date date) {
        List<Schedule> availableSchedules = new ArrayList<>();
        List<FlipFitSlot> allSlotsForGym = slotService.getAllSlotsByCentre(centreID);

        for (FlipFitSlot slot : allSlotsForGym) {
            Schedule schedule = getOrCreateSchedule(slot.getSlotId(), date);
            if (schedule.getAvailability() > 0) {
                availableSchedules.add(schedule);
            }
        }

        return availableSchedules;
    }

    public List<FlipFitSlot> getAllAvailableSlotsByDate(String centreID, Date date) {
        List<FlipFitSlot> availableSlots = new ArrayList<>();
        List<FlipFitSlot> allSlotsForCentre = slotService.getAllSlotsByCentre(centreID);

        for (FlipFitSlot slot : allSlotsForCentre) {
            Schedule schedule = getOrCreateSchedule(slot.getSlotId(), date);
            if (schedule.getAvailability() > 0) {
                availableSlots.add(slot);
            }
        }

        return availableSlots;
    }

    public Schedule getSchedule(String scheduleID) {
        return schedules.get(scheduleID);
    }

    public Schedule getOrCreateSchedule(String slotId, Date date) {
        Schedule existingSchedule = getScheduleByDateAndSlotId(slotId, date);
        if (existingSchedule != null) {
            return existingSchedule;
        }
        return createSchedule(date, slotId);
    }
}
