package com.flipkart.dao;

import com.flipkart.bean.Schedule;
import java.sql.Date;
import java.util.List;

// ScheduleInterfaceDAO interface defines methods for managing schedules in the Flipkart system
public interface ScheduleInterfaceDAO {

    /**
     * Adds a new schedule to the system.
     *
     * @param schedule Schedule object representing the schedule to add
     */
    public void addSchedule(Schedule schedule);

    /**
     * Retrieves all schedules for a specific date.
     *
     * @param date Date for which schedules are to be retrieved
     * @return List of Schedule objects representing all schedules for the specified date
     */
    public List<Schedule> getAllScheduleByDate(Date date);
}