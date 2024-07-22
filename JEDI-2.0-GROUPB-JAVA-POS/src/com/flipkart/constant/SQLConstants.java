package com.flipkart.constant;

public class SQLConstants {
    /**
     * Customer SQL Queries
     */
    public static final String ADD_NEW_CUSTOMER = "INSERT INTO FlipFitCustomer VALUES (?, ?, ?,?, ?, ?);";
    public static final String CUSTOMER_LOGIN_QUERY = "SELECT * FROM FlipFitCustomer WHERE userName = ? AND password = ?";
    public static final String GET_CUSTOMER_BY_ID = "SELECT * FROM FlipFitCustomer WHERE userName = ?;";

    /**
     * Slot SQL Queries
     */
    public static final String ADD_NEW_USER = "INSERT INTO FlipFitUser VALUES (?,?,?,?);";
    public static final String ADD_GYM_CENTRE_QUERY = "INSERT INTO  FlipFitGymCenter VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String FETCH_ALL_SLOTS ="SELECT * FROM FlipFitSlot";
    public static final String FETCH_SLOT_BY_CENTRE ="SELECT * FROM FlipFitSlot WHERE gymCenterId=?";
    public static final String ADD_SLOT ="INSERT INTO FlipFitSlot values (?, ?, ?)";
    public static final String FETCH_SLOT_BY_ID = "SELECT * FROM FlipFitSlot WHERE slotId=?";
    public static final String FETCH_SLOT_BY_ID_AND_CENTRE_ID = "SELECT * FROM FlipFitSlot WHERE slotId=? AND gymCenterId=?";
    public static final String SQL_APPROVE_GYM_CENTRE_BY_ID_QUERY="Update FlipFitGymCenter Set isApproved=? WHERE gymCenterId=?";
    public static final String FETCH_GYM_CENTRES_BY_CITY = "SELECT * FROM FlipFitGymCenter where city = ?";
    public static final String FETCH_ALL_PENDING_GYM_CENTRES_QUERY = "SELECT * FROM FlipFitGymCenter where isApproved = 2";
    public static final String FETCH_ALL_GYM_OWNERS_QUERY = "SELECT * FROM FlipFitGymOwner";
    public static final String LOGIN_GYM_OWNER = "Select * from FlipFitGymOwner where userName=? and password=?";
    public static final String REGISTER_GYM_OWNER = "Insert into FlipFitGymOwner values (?,?,?,?,?,?,?)";
    public static final String FETCH_GYM_CENTRES_BY_OWNER_ID = "SELECT * FROM FlipFitGymCenter where gymOwnerId = ?";
    public static final String FETCH_ALL_PENDING_GYM_OWNERS_QUERY = "SELECT * FROM FlipFitGymOwner where isApproved = 2";
    public static final String SEND_GYM_OWNER_APPROVAL_REQ_QUERY = "UPDATE FlipFitGymOwner SET isApproved = 2 WHERE userId =?;";
    public static final String SQL_APPROVE_GYM_OWNER_BY_ID_QUERY="Update FlipFitGymOwner Set isApproved=? WHERE userId=?";
    public static final String ADD_SCHEDULE="INSERT INTO FlipFitSchedule VALUES (?,?,?,?)";
    public static final String GET_SCHEDULES_BY_DATE="SELECT * FROM FlipFitSchedule WHERE date=?";
    public static final String GET_SCHEDULE_BY_ID ="SELECT * FROM FlipFitSchedule WHERE scheduleId=?";
    public static final String MODIFY_SCHEDULE_AVAILABILITY ="UPDATE `flipfit`.`schedule` SET availability = ? WHERE (`scheduleId` = ?)";

    public static final String FETCH_GYM_CENTRE_BY_ID = "SELECT * FROM FlipFitGymCenter where gymCenterId = ?";
    public static final String ADD_BOOKING= "INSERT INTO FlipFitBooking values( ?, ?, ?)";
    public static final String GET_BOOKING_BY_CUSTOMER_ID ="Select * From FlipFitBooking where userID = ?";
    public static final String CANCEL_BOOKING_BY_ID= "Delete from FlipFitBooking where bookingId = ?";

    public static final String GET_BOOKING_BY_BOOKING_ID ="Select * From FlipFitBooking where bookingId = ?";
    public static final String GET_USERPLAN_BY_CUSTOMER_ID = "select * from slot join schedule where slot.slotId=schedule.slotId and schedule.scheduleId=?";
}