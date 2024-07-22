package com.flipkart.dao;

import com.flipkart.bean.Schedule;
import java.sql.Date;
import java.util.List;

// ScheduleInterfaceDAO interface defines methods for managing schedules in the Flipkart system
public interface ScheduleInterfaceDAO {

    // Method to add a new schedule to the system
    public void addSchedule(Schedule schedule);

    // Method to retrieve all schedules for a specific date
    public List<Schedule> getAllScheduleByDate(Date date);
}
