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

    public String getCenterId() {
        return CenterId;
    }

    public void setCenterId(String centerID) {
        CenterId = centerID;
    }

    private LocalTime StartTime;
    private String CenterId;

    public FlipFitSlot(String slotId, LocalTime startTime, String centerID) {
        SlotId = slotId;
        StartTime = startTime;
        CenterId = centerID;
    }




}
