package com.flipkart.business;

import com.flipkart.bean.FlipFitSlot;

import java.util.List;

public class SlotServiceImpl implements SlotService{
    @Override
    public List<FlipFitSlot> getAllSlotsByCentre(String centreID) {
        return List.of();
    }

    @Override
    public FlipFitSlot getSlotByID(String slotID) {
        return null;
    }

    @Override
    public List<FlipFitSlot> getSlotList() {
        return List.of();
    }

    @Override
    public void bookSlots(String gymCentreId, List<FlipFitSlot> slotList) {

    }

    @Override
    public boolean isSlotValid(String slotID, String centreId) {
        return false;
    }

    @Override
    public void cancelSlot(String slotId, String centerId) {

    }
}
