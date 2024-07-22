package com.flipkart.constant;

public class SQLConstants {
    /**
     * Customer SQL Queries
     */
    public static final String ADD_NEW_CUSTOMER = "INSERT INTO flipfit-schema.FlipFitCustomer (Id,name,password,email,phone,cardDetails) VALUES (?, ?, ?, ?, ?, ?);";
    public static final String CUSTOMER_LOGIN_QUERY = "SELECT * FROM flipfit-schema.FlipFitCustomer WHERE name = ? AND password = ?";
    public static final String GET_CUSTOMER_BY_ID = "SELECT * FROM flipfit-schema.FlipFitCustomer WHERE name = ?;";

    /**
     * Slot SQL Queries
     */
    public static final String FETCH_ALL_SLOTS ="SELECT * FROM flipfit-schema.FlipFitSlot";
    public static final String FETCH_SLOT_BY_CENTRE ="SELECT * FROM flipfit-schema.FlipFitSlot WHERE centreId=?";
    public static final String ADD_SLOT ="INSERT INTO flipfit-schema.FlipFitSlot(slotId, centreId, time) values (?, ?, ?)";
    public static final String FETCH_SLOT_BY_ID = "SELECT * FROM flipfit-schema.FlipFitSlot WHERE slotId=?";
    public static final String FETCH_SLOT_BY_ID_AND_CENTRE_ID = "SELECT * FROM flipfit-schema.FlipFitSlot WHERE slotId=? AND centreId=?";


    public static final String FETCH_ALL_GYM_OWNERS_QUERY = "SELECT * FROM flipfit-schema.FlipFitGymOwner";
    public static final String LOGIN_GYM_OWNER = "Select * from FlipFitGymOwner where name=? and password=?";
    public static final String REGISTER_GYM_OWNER = "Insert into FlipFitGymOwner values (?,?,?,?,?,?,?)";
    public static final String FETCH_ALL_PENDING_GYM_OWNERS_QUERY = "SELECT * FROM flipfit-schema.FlipFitGymOwner where isApproved = 2";
    public static final String SEND_GYM_OWNER_APPROVAL_REQ_QUERY = "UPDATE flipfit-schema.FlipFitGymOwner SET isApproved = 2 WHERE Id =?;";
    public static final String SQL_APPROVE_GYM_OWNER_BY_ID_QUERY="Update FlipFitGymOwner Set isApproved=? WHERE Id=?";
    public static final String ADD_SCHEDULE="INSERT INTO flipfit-schema.FlipFitSchedule(scheduleId, date, slotId, availability ) values (?,?,?,?)";
    public static final String GET_SCHEDULES_BY_DATE="SELECT * FROM flipfit-schema.FlipFitSchedule WHERE date=?";
    public static final String GET_SCHEDULE_BY_ID ="SELECT * FROM flipfit-schema.FlipFitSchedule WHERE scheduleId=?";
    public static final String MODIFY_SCHEDULE_AVAILABILITY ="UPDATE `flipfit`.`schedule` SET availability = ? WHERE (`scheduleId` = ?)";


    public static final String ADD_BOOKING= "INSERT INTO flipfit-schema.FlipFitBooking (bookingId, userID, scheduleID) values( ?, ?, ?)";
    public static final String GET_BOOKING_BY_CUSTOMER_ID ="Select * From flipfit-schema.FlipFitBooking where userID = ?";
    public static final String CANCEL_BOOKING_BY_ID= "Delete from flipfit-schema.FlipFitBooking where bookingId = ?";

    public static final String GET_BOOKING_BY_BOOKING_ID ="Select * From flipfit-schema.FlipFitBooking where bookingId = ?";
    public static final String GET_USERPLAN_BY_CUSTOMER_ID = "select * from slot join schedule where slot.slotId=schedule.slotId and schedule.scheduleId=?";

}
