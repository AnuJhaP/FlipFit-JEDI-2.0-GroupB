package com.flipkart.utils;

import java.sql.Date;
import java.time.LocalTime;

/**
 * Represents a plan or schedule for a user.
 * This class encapsulates details such as slot ID, center ID, time, schedule ID, and date.
 */
public class UserPlan {
    private String slotId;
    private String centerId;
    private LocalTime time;
    private String scheduleID;
    private Date date;

    /**
     * Constructs a new UserPlan with the specified details.
     *
     * @param slotId     The ID of the slot associated with this plan.
     * @param centerID   The ID of the center associated with this plan.
     * @param time       The time of the plan.
     * @param scheduleID The ID of the schedule associated with this plan.
     * @param date       The date of the plan.
     */
    public UserPlan(String slotId, String centerID, LocalTime time, String scheduleID, Date date) {
        this.time = time;
        this.slotId = slotId;
        this.date = date;
        this.scheduleID = scheduleID;
        this.centerId = centerID;
    }

    /**
     * Returns the ID of the slot associated with this plan.
     *
     * @return The slot ID.
     */
    public String getSlotId() {
        return slotId;
    }

    /**
     * Sets the ID of the slot associated with this plan.
     *
     * @param slotId The slot ID to set.
     */
    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    /**
     * Returns the ID of the center associated with this plan.
     *
     * @return The center ID.
     */
    public String getCenterId() {
        return centerId;
    }

    /**
     * Sets the ID of the center associated with this plan.
     *
     * @param centerId The center ID to set.
     */
    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    /**
     * Returns the time of the plan.
     *
     * @return The plan time.
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * Sets the time of the plan.
     *
     * @param time The plan time to set.
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /**
     * Returns the ID of the schedule associated with this plan.
     *
     * @return The schedule ID.
     */
    public String getScheduleID() {
        return scheduleID;
    }

    /**
     * Sets the ID of the schedule associated with this plan.
     *
     * @param scheduleID The schedule ID to set.
     */
    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    /**
     * Returns the date of the plan.
     *
     * @return The plan date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the plan.
     *
     * @param date The plan date to set.
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
