package com.flipkart.dao;

import com.flipkart.bean.FlipFitSlot;
import java.util.List;

// SlotInterfaceDAO interface defines methods for managing slots in the Flipkart system
public interface SlotInterfaceDAO {

    // Method to retrieve a list of all slots in the system
    public List<FlipFitSlot> getSlotList();

    // Method to retrieve a list of slots associated with a specific gym center identified by gymCentreId
    public List<FlipFitSlot> getSlotByCentreId(String gymCentreId);

    // Method to add a new slot to the system
    public void addSlot(FlipFitSlot slot);

    // Method to retrieve a slot by its unique identifier slotID
    public FlipFitSlot getSlotById(String slotID);

    // Method to retrieve a slot by its unique identifier slotID and associated gym center identified by gymCentreId
    public FlipFitSlot getSlotByIdandCentreId(String slotID, String gymCentreId);

}
