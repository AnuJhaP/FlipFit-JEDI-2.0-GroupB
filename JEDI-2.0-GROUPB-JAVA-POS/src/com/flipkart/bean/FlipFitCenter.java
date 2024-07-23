package com.flipkart.bean;

/**
 * FlipFitCenter class represents a fitness center entity in the FlipFit system.
 * It encapsulates information about a fitness center, including its unique identifier,
 * owner details, name, GST identification number, location, capacity, price, and approval status.
 */
public class FlipFitCenter {
    private String gymCenterID;
    private String ownerID;
    private String gymCenterName;
    private String gstin;
    private String city;
    private int capacity;
    private int price;
    private int isApproved;

    /**
     * Default constructor for creating a FlipFitCenter object.
     * Initializes with default values.
     */
    public FlipFitCenter() {
        // Default constructor is empty
    }

    /**
     * Constructor to initialize all fields of the fitness center.
     *
     * @param gymCenterID   The unique identifier of the fitness center.
     * @param ownerID       The ID of the owner of the fitness center.
     * @param gymCenterName The name of the fitness center.
     * @param gstin         The GST identification number of the fitness center.
     * @param city          The city where the fitness center is located.
     * @param capacity      The maximum capacity of the fitness center.
     * @param price         The price or fee charged by the fitness center.
     */
    public FlipFitCenter(String gymCenterID, String ownerID, String gymCenterName, String gstin, String city, int capacity, int price) {
        this.gymCenterID = gymCenterID;
        this.ownerID = ownerID;
        this.gymCenterName = gymCenterName;
        this.gstin = gstin;
        this.city = city;
        this.capacity = capacity;
        this.price = price;
        this.isApproved = 0;
    }

    /**
     * Constructor to initialize all fields of the fitness center, including approval status.
     *
     * @param gymCenterID   The unique identifier of the fitness center.
     * @param ownerID       The ID of the owner of the fitness center.
     * @param gymCenterName The name of the fitness center.
     * @param gstin         The GST identification number of the fitness center.
     * @param city          The city where the fitness center is located.
     * @param capacity      The maximum capacity of the fitness center.
     * @param price         The price or fee charged by the fitness center.
     * @param isApproved    The approval status of the fitness center (0 or 1).
     */
    public FlipFitCenter(String gymCenterID, String ownerID, String gymCenterName, String gstin, String city, int capacity, int price, int isApproved) {
        this.gymCenterID = gymCenterID;
        this.ownerID = ownerID;
        this.gymCenterName = gymCenterName;
        this.gstin = gstin;
        this.city = city;
        this.capacity = capacity;
        this.price = price;
        this.isApproved = isApproved;
    }

    /**
     * Getter method to retrieve the GST identification number of the fitness center.
     *
     * @return The GST identification number of the fitness center.
     */
    public String getGstin() {
        return gstin;
    }

    /**
     * Setter method to update the GST identification number of the fitness center.
     *
     * @param gstin The new GST identification number to be set.
     */
    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    /**
     * Getter method to retrieve the price or fee charged by the fitness center.
     *
     * @return The price or fee charged by the fitness center.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Setter method to update the price or fee charged by the fitness center.
     *
     * @param price The new price or fee to be set.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Getter method to retrieve the unique identifier of the fitness center.
     *
     * @return The unique identifier of the fitness center.
     */
    public String getGymCenterID() {
        return gymCenterID;
    }

    /**
     * Setter method to update the unique identifier of the fitness center.
     *
     * @param gymCenterID The new unique identifier to be set.
     */
    public void setGymCenterID(String gymCenterID) {
        this.gymCenterID = gymCenterID;
    }

    /**
     * Getter method to retrieve the city where the fitness center is located.
     *
     * @return The city where the fitness center is located.
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter method to update the city where the fitness center is located.
     *
     * @param city The new city to be set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter method to retrieve the maximum capacity of the fitness center.
     *
     * @return The maximum capacity of the fitness center.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Setter method to update the maximum capacity of the fitness center.
     *
     * @param capacity The new maximum capacity to be set.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Getter method to retrieve the name of the fitness center.
     *
     * @return The name of the fitness center.
     */
    public String getGymCenterName() {
        return gymCenterName;
    }

    /**
     * Setter method to update the name of the fitness center.
     *
     * @param gymCenterName The new name of the fitness center to be set.
     */
    public void setGymCenterName(String gymCenterName) {
        this.gymCenterName = gymCenterName;
    }

    /**
     * Getter method to retrieve the ID of the owner of the fitness center.
     *
     * @return The ID of the owner of the fitness center.
     */
    public String getOwnerID() {
        return ownerID;
    }

    /**
     * Setter method to update the ID of the owner of the fitness center.
     *
     * @param ownerID The new ID of the owner to be set.
     */
    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    /**
     * Getter method to retrieve the approval status of the fitness center.
     *
     * @return The approval status of the fitness center (0 or 1).
     */
    public int isApproved() {
        return isApproved;
    }

    /**
     * Setter method to update the approval status of the fitness center.
     *
     * @param approved The new approval status to be set (0 or 1).
     */
    public void setApproved(int approved) {
        isApproved = approved;
    }

    /**
     * Override toString method to provide a string representation of the FlipFitCenter object.
     *
     * @return A string representation of the FlipFitCenter object.
     */
    @Override
    public String toString() {
        return "FlipFitCenter{" +
                "gymCenterID='" + gymCenterID + '\'' +
                ", gymCenterName='" + gymCenterName + '\'' +
                ", ownerID='" + ownerID + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
