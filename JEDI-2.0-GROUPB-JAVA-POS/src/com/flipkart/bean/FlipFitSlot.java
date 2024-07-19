package com.flipkart.bean;
import java.time.LocalTime;


public class FlipFitSlot {
    private String SlotId;

    public String getSlotId() {
        return SlotId;
    }

    public void setSlotId(String slotId) {
        SlotId = slotId;
    }

    public LocalTime getStartTime() {
        return StartTime;
    }

    public void setStartTime(LocalTime startTime) {
        StartTime = startTime;
    }

    public String getCenterID() {
        return CenterID;
    }

    public void setCenterID(String centerID) {
        CenterID = centerID;
    }

    private LocalTime StartTime;
    private String CenterID;

    public FlipFitSlot(String slotId, LocalTime startTime, String centerID) {
        this.SlotId = slotId;
        this.StartTime = startTime;
        this.CenterID = centerID;
    }




}
