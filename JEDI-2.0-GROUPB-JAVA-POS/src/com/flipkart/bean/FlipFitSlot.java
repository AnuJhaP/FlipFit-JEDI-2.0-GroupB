package com.flipkart.bean;

import java.time.LocalTime;

/**
 * FlipFitSlot class represents a time slot entity in the FlipFit system.
 * It encapsulates information about a slot including slot ID, time, and associated fitness center ID.
 */
public class FlipFitSlot {
    private String SlotId;       // Unique identifier for the slot
    private LocalTime time;      // Time of the slot
    private String CenterId;     // ID of the fitness center associated with the slot

    /**
     * Constructor to initialize a FlipFitSlot object with slot ID, time, and fitness center ID.
     *
     * @param slotId   The unique identifier for the slot.
     * @param time     The time of the slot represented by LocalTime.
     * @param centerId The ID of the fitness center associated with the slot.
     */
    public FlipFitSlot(String slotId, LocalTime time, String centerId) {
        this.SlotId = slotId;
        this.time = time;
        this.CenterId = centerId;
    }

    /**
     * Getter method to retrieve the slot ID.
     *
     * @return The slot ID of the FlipFitSlot object.
     */
    public String getSlotId() {
        return SlotId;
    }

    /**
     * Setter method to update the slot ID.
     *
     * @param slotId The new slot ID to be set for the FlipFitSlot object.
     */
    public void setSlotId(String slotId) {
        SlotId = slotId;
    }

    /**
     * Getter method to retrieve the time of the slot.
     *
     * @return The time of the slot as LocalTime for the FlipFitSlot object.
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * Setter method to update the time of the slot.
     *
     * @param time The new time to be set for the slot as LocalTime for the FlipFitSlot object.
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /**
     * Getter method to retrieve the fitness center ID associated with the slot.
     *
     * @return The fitness center ID associated with the slot for the FlipFitSlot object.
     */
    public String getCenterId() {
        return CenterId;
    }

    /**
     * Setter method to update the fitness center ID associated with the slot.
     *
     * @param centerId The new fitness center ID to be set for the slot for the FlipFitSlot object.
     */
    public void setCenterId(String centerId) {
        CenterId = centerId;
    }
}