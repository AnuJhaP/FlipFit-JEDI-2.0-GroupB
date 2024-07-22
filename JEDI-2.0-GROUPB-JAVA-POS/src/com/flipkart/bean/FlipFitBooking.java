package com.flipkart.bean;

// FlipFitBooking class represents a booking entity in the FlipFit system
public class FlipFitBooking {

    private String bookingID;    // Unique identifier for the booking
    private String userID;       // User ID associated with the booking
    private String scheduleID;   // Schedule ID for the booked appointment

    // Constructor for creating a booking with userID and scheduleID
    public FlipFitBooking(String userID, String scheduleID) {
        this.userID = userID;
        this.scheduleID = scheduleID;
    }

    // Constructor for creating a booking with bookingID, userID, and scheduleID
    public FlipFitBooking(String bookingID, String userID, String scheduleID) {
        this.bookingID = bookingID;
        this.userID = userID;
        this.scheduleID = scheduleID;
    }

    // Getter method for retrieving the booking ID
    public String getBookingID() {
        return bookingID;
    }

    // Setter method for updating the booking ID
    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    // Getter method for retrieving the user ID associated with the booking
    public String getUserID() {
        return userID;
    }

    // Setter method for updating the user ID associated with the booking
    public void setUserID(String userID) {
        this.userID = userID;
    }

    // Getter method for retrieving the schedule ID of the booking
    public String getScheduleID() {
        return scheduleID;
    }

    // Setter method for updating the schedule ID of the booking
    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    // Other potential fields and methods related to booking can be added here
    // For example, additional properties like userId, bookingId, isAvailable, slotId
    // could be uncommented and implemented based on system requirements.
}