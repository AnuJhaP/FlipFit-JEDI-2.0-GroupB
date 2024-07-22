package com.flipkart.bean;

// FlipFitCenter class represents a fitness center in the FlipFit system
public class FlipFitCenter {
        private String gymCenterID;
        private String ownerID;
        private String gymCenterName;
        protected String gstin;
        private String city;
        private int capacity;
        private int price;
        private int isApproved;
        public FlipFitCenter() {

        }
        @Override
        public String toString() {
            return "GymCentre{" +
                    "gymCentreID='" + gymCenterID + '\'' +
                    ", gymCenterName='" + gymCenterName + '\'' +
                    ", ownerID='" + ownerID + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
        public FlipFitCenter(String gymCentreID, String ownerID, String gymCenterName, String gstin, String city, int capacity, int price) {
            this.gymCenterID = gymCentreID;
            this.ownerID = ownerID;
            this.gymCenterName = gymCenterName;
            this.gstin = gstin;
            this.city = city;
            this.capacity = capacity;
            this.price = price;
            this.isApproved = 0;
        }

    public FlipFitCenter(String gymCentreID, String ownerID, String gymCenterName, String gstin, String city, int capacity, int price, int isApproved) {
        this.gymCenterID = gymCentreID;
        this.ownerID = ownerID;
        this.gymCenterName = gymCenterName;
        this.gstin = gstin;
        this.city = city;
        this.capacity = capacity;
        this.price = price;

        this.isApproved = isApproved;
    }

        public String getGstin() {
            return gstin;
        }

        public void setGstin(String gstin) {
            this.gstin = gstin;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getGymCenterID() {
            return gymCenterID;
        }

        public void setGymCenterID(String gymCentreID) {
            this.gymCenterID = gymCentreID;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        public String getGymCenterName() {
            return gymCenterName;
        }

        public void setGymCenterName(String gymCenterName) {
            this.gymCenterName = gymCenterName;
        }

        public String getOwnerID() {
            return ownerID;
        }

        public void setOwnerID(String ownerID) {
            this.ownerID = ownerID;
        }

        public int isApproved() {
            return isApproved;
        }

        public void setApproved(int approved) {
            isApproved = approved;
        }
    }
