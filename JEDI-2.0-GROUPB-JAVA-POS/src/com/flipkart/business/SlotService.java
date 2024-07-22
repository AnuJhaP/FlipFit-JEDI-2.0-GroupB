package com.flipkart.business;
import com.flipkart.bean.FlipFitSlot;

import java.util.List;

/**
 * @author JEDI-02
 * Interface for Slot Service Operations
 *
 */

public interface SlotService {

    /**
     * Retrieves all slots associated with a gym center.
     *
     * @param centreID ID of the gym center
     * @return List of all slots associated with the gym center
     */
    List<FlipFitSlot> getAllSlotsByCentre(String centreID);

    /**
     * Retrieves a slot by its ID.
     *
     * @param slotID ID of the slot
     * @return The FlipFitSlot object corresponding to the ID
     */
    FlipFitSlot getSlotByID(String slotID);

    /**
     * Retrieves a list of all slots.
     *
     * @return List of all slots
     */
    List<FlipFitSlot> getSlotList();

    /**
     * Adds slots to a gym center.
     *
     * @param gymCentreId ID of the gym center
     * @param slotList    List of slots to add
     */
    void addSlotsForGym(String gymCentreId, List<FlipFitSlot> slotList);

    /**
     * Checks if a slot is valid for a specific gym center.
     *
     * @param slotID   ID of the slot
     * @param centreId ID of the gym center
     * @return true if the slot is valid for the gym center, false otherwise
     */
    boolean isSlotValid(String slotID,String centreId);
}

