package com.flipkart.bean;

import java.sql.Date;
import java.util.UUID;

/**
 * Schedule class represents a schedule entity in the Flipkart system.
 * It includes details such as schedule ID, date, associated slot ID, and availability status.
 */
public class Schedule {
    private String scheduleID;   // Unique identifier for the schedule
    private Date date;           // Date of the schedule
    private String slotID;       // ID of the slot associated with the schedule
    private int availability;    // Availability status of the schedule (e.g., number of available slots)

    /**
     * Constructor to initialize Schedule object with date, slotID, and availability.
     * Generates a unique schedule ID using UUID.
     *
     * @param date         Date of the schedule
     * @param slotID       ID of the slot associated with the schedule
     * @param availability Availability status of the schedule
     */
    public Schedule(Date date, String slotID, int availability) {
        this.scheduleID = String.valueOf(UUID.randomUUID());
        this.date = date;
        this.slotID = slotID;
        this.availability = availability;
    }

    /**
     * Getter method for retrieving schedule ID.
     *
     * @return The schedule ID
     */
    public String getScheduleID() {
        return scheduleID;
    }

    /**
     * Setter method for updating schedule ID.
     *
     * @param scheduleID The new schedule ID to set
     */
    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    /**
     * Getter method for retrieving date of the schedule.
     *
     * @return The date of the schedule
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter method for updating date of the schedule.
     *
     * @param date The new date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Getter method for retrieving slot ID associated with the schedule.
     *
     * @return The slot ID associated with the schedule
     */
    public String getSlotID() {
        return slotID;
    }

    /**
     * Setter method for updating slot ID associated with the schedule.
     *
     * @param slotID The new slot ID to set
     */
    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    /**
     * Getter method for retrieving availability status of the schedule.
     *
     * @return The availability status of the schedule
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * Setter method for updating availability status of the schedule.
     *
     * @param availability The new availability status to set
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }
}