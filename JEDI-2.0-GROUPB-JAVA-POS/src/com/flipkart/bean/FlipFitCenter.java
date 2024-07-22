package com.flipkart.bean;

// FlipFitCenter class represents a fitness center in the FlipFit system
public class FlipFitCenter {
    private String gymCentreID;     // Unique identifier for the fitness center
    private String ownerID;         // ID of the owner of the fitness center
    private String gymCenterName;   // Name of the fitness center
    protected String gstin;         // GST identification number of the fitness center
    private String city;            // City where the fitness center is located
    private int capacity;           // Maximum capacity of the fitness center
    private int price;              // Price or fee charged by the fitness center
    private int isApproved;         // Approval status of the fitness center (0 or 1)

    // Default constructor
    public FlipFitCenter() {
        // Default constructor is empty
    }

    // Constructor to initialize all fields of the fitness center
    public FlipFitCenter(String gymCentreID, String ownerID, String gymCenterName, String gstin, String city, int capacity, int price) {
        this.gymCentreID = gymCentreID;
        this.ownerID = ownerID;
        this.gymCenterName = gymCenterName;
        this.gstin = gstin;
        this.city = city;
        this.capacity = capacity;
        this.price = price;
        this.isApproved = 0; // Default approval status is set to 0
    }

    // Getter method for retrieving GST identification number
    public String getGstin() {
        return gstin;
    }

    // Setter method for updating GST identification number
    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    // Getter method for retrieving price or fee
    public int getPrice() {
        return price;
    }

    // Setter method for updating price or fee
    public void setPrice(int price) {
        this.price = price;
    }

    // Getter method for retrieving fitness center ID
    public String getGymCentreID() {
        return gymCentreID;
    }

    // Setter method for updating fitness center ID
    public void setGymCentreID(String gymCentreID) {
        this.gymCentreID = gymCentreID;
    }

    // Getter method for retrieving city
    public String getCity() {
        return city;
    }

    // Setter method for updating city
    public void setCity(String city) {
        this.city = city;
    }

    // Getter method for retrieving capacity
    public int getCapacity() {
        return capacity;
    }

    // Setter method for updating capacity
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Getter method for retrieving fitness center name
    public String getGymCenterName() {
        return gymCenterName;
    }

    // Setter method for updating fitness center name
    public void setGymCenterName(String gymCenterName) {
        this.gymCenterName = gymCenterName;
    }

    // Getter method for retrieving owner ID
    public String getOwnerID() {
        return ownerID;
    }

    // Setter method for updating owner ID
    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    // Getter method for retrieving approval status
    public int isApproved() {
        return isApproved;
    }

    // Setter method for updating approval status
    public void setApproved(int approved) {
        isApproved = approved;
    }

    // Override toString method to provide a string representation of the object
    @Override
    public String toString() {
        return "FlipFitCenter{" +
                "gymCentreID='" + gymCentreID + '\'' +
                ", gymCenterName='" + gymCenterName + '\'' +
                ", ownerID='" + ownerID + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
