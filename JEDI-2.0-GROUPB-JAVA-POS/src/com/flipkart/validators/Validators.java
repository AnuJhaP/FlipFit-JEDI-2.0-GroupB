package com.flipkart.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class for validating input formats such as date, time, email, and phone numbers.
 */
public class Validators {

    /**
     * Checks if the given date string is a valid date format (dd/MM/yyyy).
     *
     * @param dateStr The date string to validate.
     * @return true if the date string is in a valid format, false otherwise.
     */
    private static boolean isValidDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); // Disable lenient parsing

        try {
            Date date = dateFormat.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * Checks if the given date string represents a future date.
     *
     * @param dateStr The date string to check.
     * @return true if the date is in the future, false otherwise or if the date string is invalid.
     */
    private static boolean isFutureDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            Date inputDate = dateFormat.parse(dateStr);
            Date currentDate = new Date();
            return inputDate.after(currentDate);
        } catch (ParseException e) {
            // Invalid date format, treat as future date
        }
        return true;
    }

    /**
     * Checks if the given date string is a valid date and not a future date.
     *
     * @param dateStr The date string to validate.
     * @return true if the date string is a valid past date, false otherwise.
     */
    public static boolean isDateValid(String dateStr) {
        return isValidDate(dateStr) && !isFutureDate(dateStr);
    }

    /**
     * Checks if the given time string matches the format HH:mm:ss.
     *
     * @param time The time string to validate.
     * @return true if the time string matches the format, false otherwise.
     */
    public boolean isTimeValid(String time) {
        String regex = "^(?:[01]\\d|2[0123]):(?:[012345]\\d):(?:[012345]\\d)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(time);
        return matcher.matches();
    }

    /**
     * Checks if the given email string matches a valid email format.
     *
     * @param email The email string to validate.
     * @return true if the email string is in a valid format, false otherwise.
     */
    public boolean isEmailValid(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Checks if the given phone number string matches a valid 10-digit Indian phone number format.
     *
     * @param phone The phone number string to validate.
     * @return true if the phone number string is in a valid format, false otherwise.
     */
    public boolean isPhoneValid(String phone) {
        if (phone.length() != 10) return false;
        String regex = "(0|91)?[6-9][0-9]{9}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

}