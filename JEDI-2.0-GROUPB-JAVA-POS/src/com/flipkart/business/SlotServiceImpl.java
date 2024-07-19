package com.flipkart.business;

import com.flipkart.bean.FlipFitSlot;

import java.util.List;

public class SlotServiceImpl implements SlotService{

public List<FlipFitSlot> getAllSlotsByCentre(String centreID) {
    return slotDAO.getSlotByCentreId(centreID);
}

    public FlipFitSlot getSlotByID(String slotID){
        return slotDAO.getSlotById(slotID);
    }

    public FlipFitSlot getSlotByIDandCentreId(String slotID,String centreId){
        return slotDAO.getSlotByIdandCentreId(slotID,centreId);
    }

    public List<FlipFitSlot> getSlotList(){
        return slotDAO.getSlotList();
    }

    public void addSlotsForGym(String gymCentreId, List<FlipFitSlot> slotList){
        System.out.println("Adding all slots to gym: " + gymCentreId);
        for(FlipFitSlot slot : slotList) {
            slot.setCentreID(gymCentreId);
            slotDAO.addSlot(slot);
        }
    }

    public boolean isSlotValid(String slotID,String centreId){
        return getSlotByIDandCentreId(slotID,centreId) != null;
    }

    }
}
