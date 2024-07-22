package com.flipkart.business;

import com.flipkart.bean.FlipFitSlot;
import com.flipkart.bean.Schedule;
import com.flipkart.dao.ScheduleDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ScheduleServiceImpl implements ScheduleService {


    private GymCenterService gymCentreService = new GymCenterServiceImpl();
    private SlotServiceImpl slotService = new SlotServiceImpl();
    private ScheduleDAO scheduleDAO = new ScheduleDAO();

    public Schedule createSchedule(Date date, String slotId){
        String centreID = slotService.getSlotByID(slotId).getCenterId();
        int availability = gymCentreService.getGymCentreById(centreID).getCapacity();
        Schedule schedule = new Schedule( date, slotId, availability);
        scheduleDAO.addSchedule(schedule);

        return schedule;
    }

    public Schedule getScheduleByDateAndSlotId(String SlotId, Date date){
        List<Schedule> scheduleList = scheduleDAO.getAllScheduleByDate(date);
        for(Schedule schedule: scheduleList){
            if(schedule.getSlotID().equals(SlotId))
                return schedule;
        }

        return null;
    }

    public boolean modifySchedule(String scheduleId,int action){
        return scheduleDAO.modifySchedule(scheduleId, action);
    }

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

    public Schedule getSchedule(String scheduleID){
        return scheduleDAO.getSchedule(scheduleID);
    }

    public Schedule getOrCreateSchedule(String slotId, Date date) {
        Schedule schedule = getScheduleByDateAndSlotId(slotId, date);
        if( schedule == null ){
            return createSchedule(date,slotId);
        }
        return schedule;

    }

}
