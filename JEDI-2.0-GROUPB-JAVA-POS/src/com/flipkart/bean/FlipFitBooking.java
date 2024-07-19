package com.flipkart.bean;

public class FlipFitBooking {
    private String userId;

    private String bookingId;

    private int isAvailable;

    public String getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    private String slotId;
    private String scheduleID;

    public FlipFitBooking(String userID, String scheduleID) {
        this.userId = userID;
        this.scheduleID = scheduleID;
    }
    public FlipFitBooking(String bookingID,String userID, String scheduleID) {
        this.bookingId = bookingID;
        this.userId = userID;
        this.scheduleID = scheduleID;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(int isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

}
