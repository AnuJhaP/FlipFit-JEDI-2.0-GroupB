package com.flipkart.bean;
import java.util.ArrayList;
public class FlipFitCenter {

    private int centerId;

    private int ownerId;

    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<FlipFitSlot> getSlots() {
        return slots;
    }

    public void setSlots(ArrayList<FlipFitSlot> slots) {
        this.slots = slots;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    private ArrayList<FlipFitSlot> slots;

}
