package com.flipkart.bean;

public class FlipFitBooking {


    private String bookingID;
    private String userID;
    private String scheduleID;

    public FlipFitBooking(String userID, String scheduleID) {
        this.userID = userID;
        this.scheduleID = scheduleID;
    }
    public FlipFitBooking(String bookingID,String userID, String scheduleID) {
        this.bookingID = bookingID;
        this.userID = userID;
        this.scheduleID = scheduleID;
    }


    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

//    private int userId;
//
//    private int bookingId;
//
//    private int isAvailable;
//
//    private int slotId;
//
//    public int getBookingId() {
//        return bookingId;
//    }
//
//    public void setBookingId(int bookingId) {
//        this.bookingId = bookingId;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public int getIsAvailable() {
//        return isAvailable;
//    }
//
//    public void setIsAvailable(int isAvailable) {
//        this.isAvailable = isAvailable;
//    }
//
//    public int getSlotId() {
//        return slotId;
//    }
//
//    public void setSlotId(int slotId) {
//        this.slotId = slotId;
//    }

}
