package com.flipkart.business;

import com.flipkart.bean.FlipFitSlot;

import java.util.ArrayList;
import java.util.List;

//public class SlotServiceImpl implements SlotService{
//
//public List<FlipFitSlot> getAllSlotsByCentre(String centreID) {
//    return slotDAO.getSlotByCentreId(centreID);
//}
//
//    public FlipFitSlot getSlotByID(String slotID){
//        return slotDAO.getSlotById(slotID);
//    }
//
//    public FlipFitSlot getSlotByIDandCentreId(String slotID,String centreId){
//        return slotDAO.getSlotByIdandCentreId(slotID,centreId);
//    }
//
//    public List<FlipFitSlot> getSlotList(){
//        return slotDAO.getSlotList();
//    }
//
//    public void addSlotsForGym(String gymCentreId, List<FlipFitSlot> slotList){
//        System.out.println("Adding all slots to gym: " + gymCentreId);
//        for(FlipFitSlot slot : slotList) {
//            slot.setCenterId(gymCentreId);
//            slotDAO.addSlot(slot);
//        }
//    }
//
//    public boolean isSlotValid(String slotID,String centreId){
//        return getSlotByIDandCentreId(slotID,centreId) != null;
//    }
//
//    }
public class SlotServiceImpl implements SlotService {

    private ArrayList<FlipFitSlot> slots = new ArrayList<>();

    public List<FlipFitSlot> getAllSlotsByCentre(String centreID) {
        List<FlipFitSlot> slotsByCentre = new ArrayList<>();
        for (FlipFitSlot slot : slots) {
            if (slot.getCenterId().equals(centreID)) {
                slotsByCentre.add(slot);
            }
        }
        return slotsByCentre;
    }
    public void bookSlots(String gymCentreId, List<FlipFitSlot> slotList){
        System.out.println("Adding all slots to gym: " + gymCentreId);
        for(FlipFitSlot slot : slotList) {
            slot.setSlotId(gymCentreId);
            slots.add(slot);
        }
    }

    public FlipFitSlot getSlotByID(String slotID) {
        for (FlipFitSlot slot : slots) {
            if (slot.getSlotId().equals(slotID)) {
                return slot;
            }
        }
        return null;
    }

    public FlipFitSlot getSlotByIDandCentreId(String slotID, String centreId) {
        for (FlipFitSlot slot : slots) {
            if (slot.getSlotId().equals(slotID) && slot.getCenterId().equals(centreId)) {
                return slot;
            }
        }
        return null;
    }

    public List<FlipFitSlot> getSlotList() {
        return slots;
    }

    public void addSlotsForGym(String gymCentreId, List<FlipFitSlot> slotList) {
        for (FlipFitSlot slot : slotList) {
            slot.setCenterId(gymCentreId);
            slots.add(slot);
        }
    }

    public boolean isSlotValid(String slotID, String centreId) {
        return getSlotByIDandCentreId(slotID, centreId) != null;
    }
}

