package com.flipkart.dao;

import com.flipkart.bean.FlipFitSlot;
import java.util.List;

// SlotInterfaceDAO interface defines methods for managing slots in the Flipkart system
public interface SlotInterfaceDAO {

    /**
     * Retrieves a list of all slots in the system.
     *
     * @return List of FlipFitSlot objects representing all slots in the system
     */
    public List<FlipFitSlot> getSlotList();

    /**
     * Retrieves a list of slots associated with a specific gym center identified by gymCentreId.
     *
     * @param gymCentreId ID of the gym center for which slots are to be retrieved
     * @return List of FlipFitSlot objects representing slots associated with the specified gym center
     */
    public List<FlipFitSlot> getSlotByCentreId(String gymCentreId);

    /**
     * Adds a new slot to the system.
     *
     * @param slot FlipFitSlot object representing the slot to add
     */
    public void addSlot(FlipFitSlot slot);

    /**
     * Retrieves a slot by its unique identifier slotID.
     *
     * @param slotID Unique identifier of the slot to retrieve
     * @return FlipFitSlot object representing the slot with the specified ID
     */
    public FlipFitSlot getSlotById(String slotID);

    /**
     * Retrieves a slot by its unique identifier slotID and associated gym center identified by gymCentreId.
     *
     * @param slotID      Unique identifier of the slot to retrieve
     * @param gymCentreId ID of the gym center associated with the slot
     * @return FlipFitSlot object representing the slot with the specified ID and gym center ID
     */
    public FlipFitSlot getSlotByIdandCentreId(String slotID, String gymCentreId);
}
