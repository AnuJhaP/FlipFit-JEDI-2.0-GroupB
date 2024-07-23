package com.flipkart.bean;

/**
 * FlipFitBooking class represents a booking entity in the FlipFit system.
 * It encapsulates information about a booking, including booking ID, user ID,
 * and schedule ID.
 */
public class FlipFitBooking {

    private String bookingID;    // Unique identifier for the booking
    private String userID;       // User ID associated with the booking
    private String scheduleID;   // Schedule ID for the booked appointment

    /**
     * Constructor for creating a new booking with specified userID and scheduleID.
     *
     * @param userID     The ID of the user making the booking.
     * @param scheduleID The ID of the schedule for the booked appointment.
     */
    public FlipFitBooking(String userID, String scheduleID) {
        this.userID = userID;
        this.scheduleID = scheduleID;
    }

    /**
     * Constructor for creating a new booking with specified bookingID, userID, and scheduleID.
     *
     * @param bookingID  The unique ID of the booking.
     * @param userID     The ID of the user making the booking.
     * @param scheduleID The ID of the schedule for the booked appointment.
     */
    public FlipFitBooking(String bookingID, String userID, String scheduleID) {
        this.bookingID = bookingID;
        this.userID = userID;
        this.scheduleID = scheduleID;
    }

    /**
     * Getter method to retrieve the booking ID.
     *
     * @return The booking ID.
     */
    public String getBookingID() {
        return bookingID;
    }

    /**
     * Setter method to update the booking ID.
     *
     * @param bookingID The new booking ID to be set.
     */
    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    /**
     * Getter method to retrieve the user ID associated with the booking.
     *
     * @return The user ID associated with the booking.
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Setter method to update the user ID associated with the booking.
     *
     * @param userID The new user ID to be associated with the booking.
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * Getter method to retrieve the schedule ID of the booking.
     *
     * @return The schedule ID of the booking.
     */
    public String getScheduleID() {
        return scheduleID;
    }

    /**
     * Setter method to update the schedule ID of the booking.
     *
     * @param scheduleID The new schedule ID to be set for the booking.
     */
    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    // Other potential fields and methods related to booking can be added here
    // For example, additional properties like userId, bookingId, isAvailable, slotId
    // could be uncommented and implemented based on system requirements.
}
