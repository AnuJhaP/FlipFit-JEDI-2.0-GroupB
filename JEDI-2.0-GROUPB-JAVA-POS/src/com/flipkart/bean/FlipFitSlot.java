package com.flipkart.bean;
import java.util.ArrayList;
public class FlipFitSlot {
    private int SlotId;
    private String StartTime;
    private int CenterID;

    private ArrayList<FlipFitCustomer> Bookings;

    public int getSlotId() {
        return SlotId;
    }

    public void setSlotId(int slotId) {
        SlotId = slotId;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public int getCenterID() {
        return CenterID;
    }

    public void setCenterID(int centerID) {
        CenterID = centerID;
    }

    public ArrayList<FlipFitCustomer> getBookings() {
        return Bookings;
    }

    public void setBookings(ArrayList<FlipFitCustomer> bookings) {
        Bookings = bookings;
    }
}
