package com.flipkart.dao;

import com.flipkart.bean.FlipFitBooking;
import com.flipkart.exceptions.BookingFailedException;
import com.flipkart.utils.UserPlan;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.flipkart.constant.SQLConstants.*;

/**
 * DAO class for handling booking-related operations in the Flipkart system.
 * This class manages the CRUD operations related to bookings in the Flipkart system,
 * including adding, retrieving, cancelling bookings, and checking for overlaps.
 */
public class BookingDAO {

    /**
     * Constructor for Booking DAO
     */
    public BookingDAO() {
    }

    // Instance of ScheduleDAO for managing schedules
    ScheduleDAO scheduleDAO = new ScheduleDAO();

    /**
     * Adds a booking for a user into the database.
     *
     * @param userName   Username of the customer making the booking
     * @param scheduleID ID of the schedule being booked
     * @throws BookingFailedException if the booking operation fails
     */
    public void addBooking(String userName, String scheduleID) throws BookingFailedException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema", "root", "Poojayadav5*");

            PreparedStatement stmt = conn.prepareStatement(ADD_BOOKING);
            stmt.setString(1, userName + scheduleID);
            stmt.setString(2, userName);
            stmt.setString(3, scheduleID);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException exp) {
            throw new BookingFailedException("Booking failed for current slot. Try again later.");
        } catch (Exception exp) {
            System.out.println("Oops! An error occurred. Try again later.");
        }
    }

    /**
     * Retrieves all bookings made by a customer using their customerId.
     *
     * @param customerId ID of the customer whose bookings are to be retrieved
     * @return List of FlipFitBooking objects representing the bookings
     * @throws BookingFailedException if the retrieval operation fails
     */
    public List<FlipFitBooking> getBookingByCustomerId(String customerId) throws BookingFailedException {
        List<FlipFitBooking> allBookingList = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema", "root", "Poojayadav5*");

            PreparedStatement stmt = conn.prepareStatement(GET_BOOKING_BY_CUSTOMER_ID);
            stmt.setString(1, customerId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                FlipFitBooking booking = new FlipFitBooking(
                        rs.getString("bookingId"),
                        rs.getString("userID"),
                        rs.getString("scheduleID")
                );
                allBookingList.add(booking);
            }
        } catch (SQLException sql) {
            throw new BookingFailedException("Could not retrieve bookings by customer id:  " + customerId);
        } catch (Exception e) {
            System.out.println("Oops! An error occurred. Try again later.");
        }
        return allBookingList;
    }

    /**
     * Retrieves all user plans (bookings) for a customer.
     *
     * @param customerId ID of the customer whose plans are to be retrieved
     * @return List of UserPlan objects representing the customer's plans
     */
    public List<UserPlan> getCustomerPlan(String customerId) {
        List<UserPlan> allUserPlan = new ArrayList<>();
        List<FlipFitBooking> allBookingList = getBookingByCustomerId(customerId);
        for (FlipFitBooking booking : allBookingList) {
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema", "root", "Poojayadav5*");

                PreparedStatement stmt = conn.prepareStatement(GET_USERPLAN_BY_CUSTOMER_ID);
                stmt.setString(1, booking.getScheduleID());
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    UserPlan userPlan = new UserPlan(
                            rs.getString("slotId"),
                            rs.getString("centreId"),
                            rs.getTime("time").toLocalTime(),
                            rs.getString("scheduleID"),
                            rs.getDate("date")
                    );
                    allUserPlan.add(userPlan);
                }
            } catch (Exception e) {
                System.out.println("Could not retrieve User Plan. Try again later.");
            }
        }
        return allUserPlan;
    }

    /**
     * Checks if a booking overlaps with existing bookings for a customer.
     *
     * @param customerId ID of the customer
     * @param date       Date of the booking
     * @param localTime  Time of the booking
     * @return true if there is an overlap, false otherwise
     */
    public boolean checkBookingOverlap(String customerId, Date date, LocalTime localTime) {
        LocalTime endTime = localTime.plusHours(1);

        List<UserPlan> allUserPlan = getCustomerPlan(customerId);
        for (UserPlan userPlan : allUserPlan) {
            if (userPlan.getDate().equals(date)) {
                if (localTime.compareTo(userPlan.getTime()) <= 0 && endTime.compareTo(userPlan.getTime()) >= 0) {
                    return true;
                } else if (userPlan.getTime().compareTo(localTime) <= 0 && userPlan.getTime().compareTo(endTime) >= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Cancels a booking based on its booking ID.
     *
     * @param bookingID ID of the booking to be cancelled
     * @throws BookingFailedException if the cancellation operation fails
     */
    public void cancelBookingById(String bookingID) throws BookingFailedException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema", "root", "Poojayadav5*");
            PreparedStatement stmt = conn.prepareStatement(CANCEL_BOOKING_BY_ID);
            stmt.setString(1, bookingID);
            stmt.executeUpdate();
        } catch (SQLException sql) {
            throw new BookingFailedException("Could not cancel booking for BookingId: " + bookingID);
        } catch (Exception e) {
            System.out.println("Oops! An error occurred. Try again later.");
        }
    }

    /**
     * Retrieves a booking based on its booking ID.
     *
     * @param bookingId ID of the booking to retrieve
     * @return FlipFitBooking object representing the booking
     * @throws BookingFailedException if the retrieval operation fails
     */
    public FlipFitBooking getBookingByBookingId(String bookingId) throws BookingFailedException {
        FlipFitBooking booking = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema", "root", "Poojayadav5*");

            PreparedStatement stmt = conn.prepareStatement(GET_BOOKING_BY_BOOKING_ID);
            stmt.setString(1, bookingId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                booking = new FlipFitBooking(
                        rs.getString("bookingId"),
                        rs.getString("userID"),
                        rs.getString("scheduleID")
                );
            }
        } catch (SQLException sql) {
            throw new BookingFailedException("Could not fetch booking by bookingId: " + bookingId);
        } catch (Exception excep) {
            System.out.println("Oops! An error occurred. Try again later.");
        }
        return booking;
    }
}