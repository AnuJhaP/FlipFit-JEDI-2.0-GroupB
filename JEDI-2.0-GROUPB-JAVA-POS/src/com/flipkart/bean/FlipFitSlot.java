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

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime startTime) {
        time = time;
    }

    public String getCenterId() {
        return CenterId;
    }

    public void setCenterId(String centerId) {
        CenterId = centerId;
    }

    private LocalTime time;
    private String CenterId;

    public FlipFitSlot(String slotId, LocalTime time, String centerId) {
        this.SlotId = slotId;
        this.time = time;
        this.CenterId = centerId;
    }




}
