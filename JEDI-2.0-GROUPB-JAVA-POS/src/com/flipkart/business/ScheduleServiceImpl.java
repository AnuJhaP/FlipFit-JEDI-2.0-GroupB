package com.flipkart.business;

import com.flipkart.bean.FlipFitSlot;
import com.flipkart.bean.Schedule;

import java.util.Date;
import java.util.List;

public class ScheduleServiceImpl implements ScheduleService {

    @Override
    public Schedule createSchedule(Date date, String slotId) {
        return null;
    }

    @Override
    public Schedule getScheduleByDateAndSlotId(String SlotId, Date date) {
        return null;
    }

    @Override
    public boolean modifySchedule(String scheduleId, int action) {
        return false;
    }

    @Override
    public List<Schedule> checkAvailability(String centreID, Date date) {
        return List.of();
    }

    @Override
    public List<FlipFitSlot> getAllAvailableSlotsByDate(String centreID, Date date) {
        return List.of();
    }

    @Override
    public Schedule getOrCreateSchedule(String slotId, Date date) {
        return null;
    }
}
