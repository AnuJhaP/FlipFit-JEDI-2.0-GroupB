package com.flipkart.constant;

/**
 * Class containing SQL queries used in the FlipFit application.
 */
public class SQLConstant {

    /**
     * Customer SQL Queries
     */

    /**
     * SQL query to add a new customer.
     */
    public static final String ADD_NEW_CUSTOMER = "INSERT INTO FlipFitCustomer VALUES (?, ?, ?, ?, ?, ?);";

    /**
     * SQL query to retrieve customer information by username.
     */
    //public static final String CUSTOMER_LOGIN_QUERY = "SELECT * FROM FlipFitCustomer WHERE userName = ? AND password = ?";

    /**
     * SQL query to get customer information by username.
     */
    public static final String GET_CUSTOMER_BY_ID = "SELECT * FROM FlipFitCustomer WHERE userName = ?;";

    /**
     * User SQL Queries
     */

    /**
     * SQL query to add a new user.
     */
    public static final String ADD_NEW_USER = "INSERT INTO FlipFitUser VALUES (?, ?, ?, ?);";

    /**
     * Gym Center SQL Queries
     */

    /**
     * SQL query to add a new gym center.
     */
    public static final String ADD_GYM_CENTRE_QUERY = "INSERT INTO FlipFitGymCenter VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

    /**
     * SQL query to fetch all slots.
     */
    public static final String FETCH_ALL_SLOTS = "SELECT * FROM FlipFitSlot";

    /**
     * SQL query to fetch slots by gym center ID.
     */
    public static final String FETCH_SLOT_BY_CENTRE = "SELECT * FROM FlipFitSlot WHERE gymCenterId = ?";

    /**
     * SQL query to add a new slot.
     */
    public static final String ADD_SLOT = "INSERT INTO FlipFitSlot VALUES (?, ?, ?)";

    /**
     * SQL query to fetch a slot by ID.
     */
    public static final String FETCH_SLOT_BY_ID = "SELECT * FROM FlipFitSlot WHERE slotId = ?";

    /**
     * SQL query to fetch a slot by ID and gym center ID.
     */
    public static final String FETCH_SLOT_BY_ID_AND_CENTRE_ID = "SELECT * FROM FlipFitSlot WHERE slotId = ? AND gymCenterId = ?";

    /**
     * SQL query to approve or reject a gym center by ID.
     */
    public static final String SQL_APPROVE_GYM_CENTRE_BY_ID_QUERY = "UPDATE FlipFitGymCenter SET isApproved = ? WHERE gymCenterId = ?";

    /**
     * SQL query to fetch gym centers by city.
     */
    public static final String FETCH_GYM_CENTRES_BY_CITY = "SELECT * FROM FlipFitGymCenter WHERE city = ?";

    /**
     * SQL query to fetch all pending gym centers.
     */
    public static final String FETCH_ALL_PENDING_GYM_CENTRES_QUERY = "SELECT * FROM FlipFitGymCenter WHERE isApproved = 2";

    /**
     * Gym Owner SQL Queries
     */

    /**
     * SQL query to fetch all gym owners.
     */
    public static final String FETCH_ALL_GYM_OWNERS_QUERY = "SELECT * FROM FlipFitGymOwner";

    /**
     * SQL query to login a gym owner.
     */
    public static final String LOGIN_GYM_OWNER = "SELECT * FROM FlipFitGymOwner WHERE userName = ? AND password = ?";

    /**
     * SQL query to register a new gym owner.
     */
    public static final String REGISTER_GYM_OWNER = "INSERT INTO FlipFitGymOwner VALUES (?, ?, ?, ?, ?, ?, ?)";

    /**
     * SQL query to fetch gym centers by owner ID.
     */
    public static final String FETCH_GYM_CENTRES_BY_OWNER_ID = "SELECT * FROM FlipFitGymCenter WHERE gymOwnerId = ?";

    /**
     * SQL query to fetch all pending gym owners.
     */
    public static final String FETCH_ALL_PENDING_GYM_OWNERS_QUERY = "SELECT * FROM FlipFitGymOwner WHERE isApproved = 2";

    /**
     * SQL query to send approval request for a gym owner.
     */
    public static final String SEND_GYM_OWNER_APPROVAL_REQ_QUERY = "UPDATE FlipFitGymOwner SET isApproved = 2 WHERE userId = ?";

    /**
     * SQL query to approve or reject a gym owner by ID.
     */
    public static final String SQL_APPROVE_GYM_OWNER_BY_ID_QUERY = "UPDATE FlipFitGymOwner SET isApproved = ? WHERE userId = ?";

    /**
     * Schedule SQL Queries
     */

    /**
     * SQL query to add a new schedule.
     */
    public static final String ADD_SCHEDULE = "INSERT INTO FlipFitSchedule VALUES (?, ?, ?, ?)";

    /**
     * SQL query to fetch schedules by date.
     */
    public static final String GET_SCHEDULES_BY_DATE = "SELECT * FROM FlipFitSchedule WHERE date = ?";

    /**
     * SQL query to fetch a schedule by ID.
     */
    public static final String GET_SCHEDULE_BY_ID = "SELECT * FROM FlipFitSchedule WHERE scheduleId = ?";

    /**
     * SQL query to modify schedule availability.
     */
    public static final String MODIFY_SCHEDULE_AVAILABILITY = "UPDATE FlipFitSchedule SET availability = ? WHERE scheduleId = ?";

    /**
     * Booking SQL Queries
     */

    /**
     * SQL query to fetch a gym center by ID.
     */
    public static final String FETCH_GYM_CENTRE_BY_ID = "SELECT * FROM FlipFitGymCenter WHERE gymCenterId = ?";

    /**
     * SQL query to add a new booking.
     */
    public static final String ADD_BOOKING = "INSERT INTO FlipFitBooking VALUES (?, ?, ?)";

    /**
     * SQL query to fetch bookings by customer ID.
     */
    public static final String GET_BOOKING_BY_CUSTOMER_ID = "SELECT * FROM FlipFitBooking WHERE userID = ?";

    /**
     * SQL query to cancel a booking by ID.
     */
    public static final String CANCEL_BOOKING_BY_ID = "DELETE FROM FlipFitBooking WHERE bookingId = ?";

    /**
     * SQL query to fetch a booking by booking ID.
     */
    public static final String GET_BOOKING_BY_BOOKING_ID = "SELECT * FROM FlipFitBooking WHERE bookingId = ?";

    /**
     * SQL query to fetch user plan by customer ID.
     */
    public static final String GET_USERPLAN_BY_CUSTOMER_ID = "SELECT * FROM FlipFitSlot JOIN FlipFitSchedule WHERE FlipFitSlot.slotId = FlipFitSchedule.slotId AND FlipFitSchedule.scheduleId = ?";
}
