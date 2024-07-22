package com.flipkart.bean;

// Address class represents a physical address with city, state, pincode, and street address details
public class Address {
    // Fields to store address information
    private String city;            // City of the address
    private String state;           // State of the address
    private String pincode;         // Pincode of the address
    private String streetAdress;    // Street address (including house number, apartment number, etc.)

    // Constructor to initialize the Address object with all details
    public Address(String city, String state, String pincode, String streetAdress) {
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.streetAdress = streetAdress;
    }

    // Getter method for retrieving pincode
    public String getPincode() {
        return pincode;
    }

    // Setter method for updating pincode
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    // Getter method for retrieving street address
    public String getStreetAdress() {
        return streetAdress;
    }

    // Setter method for updating street address
    public void setStreetAdress(String streetAdress) {
        this.streetAdress = streetAdress;
    }

    // Getter method for retrieving city
    public String getCity() {
        return city;
    }

    // Setter method for updating city
    public void setCity(String city) {
        this.city = city;
    }

    // Getter method for retrieving state
    public String getState() {
        return state;
    }

    // Setter method for updating state
    public void setState(String state) {
        this.state = state;
    }
}