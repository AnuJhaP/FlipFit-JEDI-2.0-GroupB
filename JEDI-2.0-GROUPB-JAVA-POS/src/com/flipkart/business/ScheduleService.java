package com.flipkart.business;

import com.flipkart.bean.FlipFitSlot;
import com.flipkart.bean.Schedule;

import java.util.Date;
import java.util.List;

public interface ScheduleService {
    Schedule createSchedule(Date date, String slotId);
    Schedule getScheduleByDateAndSlotId(String SlotId, Date date);
    boolean modifySchedule(String scheduleId,int action);
    List<Schedule> checkAvailability(String centreID, Date date);
    List<FlipFitSlot> getAllAvailableSlotsByDate(String centreID, Date date);
    Schedule getOrCreateSchedule(String slotId, Date date);
}

