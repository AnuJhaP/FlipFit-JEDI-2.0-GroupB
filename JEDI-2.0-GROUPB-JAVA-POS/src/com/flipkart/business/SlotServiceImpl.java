package com.flipkart.business;

import com.flipkart.bean.FlipFitSlot;
import com.flipkart.dao.SlotDAO;
import java.util.List;

/**
 * @author JEDI-02
 * Service implementation for Slot Operations
 *
 */

public class SlotServiceImpl implements SlotService{
    private static SlotDAO slotDAO = new SlotDAO();

    /**
     * Retrieves all slots associated with a gym center.
     *
     * @param centreID ID of the gym center
     * @return List of all slots associated with the gym center
     */
    public List<FlipFitSlot> getAllSlotsByCentre(String centreID) {
        return slotDAO.getSlotByCentreId(centreID);
    }

    /**
     * Retrieves a slot by its ID.
     *
     * @param slotID ID of the slot
     * @return The FlipFitSlot object corresponding to the ID
     */
    public FlipFitSlot getSlotByID(String slotID){
        return slotDAO.getSlotById(slotID);
    }

    /**
     * Retrieves a slot by its ID and gym center ID.
     *
     * @param slotID   ID of the slot
     * @param centreId ID of the gym center
     * @return The FlipFitSlot object corresponding to the ID and gym center ID
     */
    public FlipFitSlot getSlotByIDandCentreId(String slotID,String centreId){
        return slotDAO.getSlotByIdandCentreId(slotID,centreId);
    }

    /**
     * Retrieves a list of all slots.
     *
     * @return List of all slots
     */
    public List<FlipFitSlot> getSlotList(){
        return slotDAO.getSlotList();
    }

    /**
     * Adds slots to a gym center.
     *
     * @param gymCentreId ID of the gym center
     * @param slotList    List of slots to add
     */
    public void addSlotsForGym(String gymCentreId, List<FlipFitSlot> slotList){
        System.out.println("Adding all slots to gym: " + gymCentreId);
        for(FlipFitSlot slot : slotList) {
            slot.setCenterId(gymCentreId);
            slotDAO.addSlot(slot);
        }
    }

    /**
     * Checks if a slot is valid for a specific gym center.
     *
     * @param slotID   ID of the slot
     * @param centreId ID of the gym center
     * @return true if the slot is valid for the gym center, false otherwise
     */
    public boolean isSlotValid(String slotID,String centreId){
        return getSlotByIDandCentreId(slotID,centreId) != null;
    }}