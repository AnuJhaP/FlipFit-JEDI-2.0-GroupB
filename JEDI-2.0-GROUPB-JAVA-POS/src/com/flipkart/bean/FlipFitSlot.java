package com.flipkart.bean;

import java.time.LocalTime;

// FlipFitSlot class represents a time slot entity in the FlipFit system
public class FlipFitSlot {
    private String SlotId;       // Unique identifier for the slot
    private LocalTime time;      // Time of the slot
    private String CenterId;     // ID of the fitness center associated with the slot

    // Constructor to initialize FlipFitSlot object with slotId, time, and centerId
    public FlipFitSlot(String slotId, LocalTime time, String centerId) {
        this.SlotId = slotId;
        this.time = time;
        this.CenterId = centerId;
    }

    // Getter method for retrieving slot ID
    public String getSlotId() {
        return SlotId;
    }

    // Setter method for updating slot ID
    public void setSlotId(String slotId) {
        SlotId = slotId;
    }

    // Getter method for retrieving time of the slot
    public LocalTime getTime() {
        return time;
    }

    // Setter method for updating time of the slot
    public void setTime(LocalTime time) {
        this.time = time;
    }

    // Getter method for retrieving center ID associated with the slot
    public String getCenterId() {
        return CenterId;
    }

    // Setter method for updating center ID associated with the slot
    public void setCenterId(String centerId) {
        CenterId = centerId;
    }
}
