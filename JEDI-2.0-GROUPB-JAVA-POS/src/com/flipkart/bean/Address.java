package com.flipkart.bean;

public class Address {
    private String city;
    private String state;
    private String pincode;
    private String streetAdress;
    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getStreetAdress() {
        return streetAdress;
    }

    public void setStreetAdress(String streetAdress) {
        this.streetAdress = streetAdress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }



}
