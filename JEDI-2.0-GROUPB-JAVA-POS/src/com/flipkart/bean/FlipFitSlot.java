package com.flipkart.bean;
import java.util.ArrayList;
public class FlipFitSlot {
    private int SlotId;
    private String StartTime;

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

    public int getNoOfSeatsAvailable() {
        return NoOfSeatsAvailable;
    }

    public void setNoOfSeatsAvailable(int noOfSeatsAvailable) {
        NoOfSeatsAvailable = noOfSeatsAvailable;
    }

    public ArrayList<FlipFitCustomer> getBookings() {
        return Bookings;
    }

    public void setBookings(ArrayList<FlipFitCustomer> bookings) {
        Bookings = bookings;
    }

    private int CenterID;
    private int NoOfSeatsAvailable;
    private ArrayList<FlipFitCustomer> Bookings;
}
