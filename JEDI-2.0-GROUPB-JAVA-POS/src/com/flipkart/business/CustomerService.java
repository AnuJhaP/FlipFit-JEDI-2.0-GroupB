package com.flipkart.business;


import com.flipkart.bean.*;
import com.flipkart.utils.UserPlan;

import java.util.List;
import java.sql.Date;

/**
 * @author JEDI-02
 * Interface for Customer Service Operations
 *
 */

public interface CustomerService {

        /**
         * Retrieves details of all gym centers in a specified city.
         *
         * @param city City name
         * @return List of gym centers in the specified city
         */
        List<FlipFitCenter> getAllGymCenterDetailsByCity(String city);

        /**
         * Retrieves available slots for booking at a specified gym center on a given date.
         *
         * @param centreID ID of the gym center
         * @param date     Date for which available slots are requested
         * @return List of available slots
         */
        List<FlipFitSlot> getAvailableSlots(String centreID, Date date);

        /**
         * Retrieves bookings made by a customer based on customer ID.
         *
         * @param customerId Customer ID
         * @return List of bookings made by the customer
         */
        List<FlipFitBooking> getCustomerBookings(String customerId);

        /**
         * Books a slot for a customer at a specified gym center on a given date.
         *
         * @param userID   User ID of the customer
         * @param date     Date of the booking
         * @param slotId   Slot ID to book
         * @param centreId ID of the gym center
         * @return true if booking was successful, false otherwise
         */
        boolean bookSlot(String userID,Date date, String slotId,String centreId);

        /**
         * Cancels a booking based on booking ID.
         *
         * @param bookingID Booking ID to cancel
         */
        void cancelBookingbyID(String bookingID);

        /**
         * Registers a new customer with the provided details.
         *
         * @param userName    Username of the new customer
         * @param password    Password of the new customer
         * @param email       Email of the new customer
         * @param phoneNumber Phone number of the new customer
         * @param cardNumber  Card number of the new customer
         */
        void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber);

        /**
         * Retrieves the profile details of a customer based on username.
         *
         * @param userName Username of the customer
         * @return Profile details of the customer
         */

        FlipFitCustomer viewMyProfile(String userName);

        /**
         * Checks if a user with the specified username and password exists and is valid.
         *
         * @param userName Username of the user
         * @param password Password of the user
         * @return true if user is valid, false otherwise
         */
        boolean isUserValid(String userName, String password);

        /**
         * Retrieves the plan(s) associated with a customer based on username.
         *
         * @param userName Username of the customer
         * @return List of plans associated with the customer
         */
        List<UserPlan> getCustomerPlan(String userName);
    }
