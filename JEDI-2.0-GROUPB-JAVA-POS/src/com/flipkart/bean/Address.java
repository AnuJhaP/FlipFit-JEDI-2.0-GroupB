package com.flipkart.bean;

/**
 * Address class represents a physical address with city, state, pincode, and street address details.
 */
public class Address {
    // Fields to store address information

    private String city;            // City of the address
    private String state;           // State of the address
    private String pincode;         // Pincode of the address
    private String streetAddress;   // Street address (including house number, apartment number, etc.)

    /**
     * Constructor to initialize the Address object with all details.
     *
     * @param city         The city where the address is located.
     * @param state        The state where the address is located.
     * @param pincode      The pincode (ZIP code) of the address.
     * @param streetAddress The detailed street address (including house number, apartment number, etc.).
     */
    public Address(String city, String state, String pincode, String streetAddress) {
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.streetAddress = streetAddress;
    }

    /**
     * Getter method for retrieving the pincode.
     *
     * @return The pincode (ZIP code) of the address.
     */
    public String getPincode() {
        return pincode;
    }

    /**
     * Setter method for updating the pincode.
     *
     * @param pincode The new pincode (ZIP code) to be set.
     */
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    /**
     * Getter method for retrieving the street address.
     *
     * @return The detailed street address (including house number, apartment number, etc.).
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Setter method for updating the street address.
     *
     * @param streetAddress The new street address to be set.
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * Getter method for retrieving the city.
     *
     * @return The city of the address.
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter method for updating the city.
     *
     * @param city The new city to be set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter method for retrieving the state.
     *
     * @return The state of the address.
     */
    public String getState() {
        return state;
    }

    /**
     * Setter method for updating the state.
     *
     * @param state The new state to be set.
     */
    public void setState(String state) {
        this.state = state;
    }
}