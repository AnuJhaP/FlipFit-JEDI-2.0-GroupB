package com.flipkart.dao;

import com.flipkart.bean.FlipFitSlot;

import java.util.List;

public class SlotDAO implements SlotInterfaceDAO{
    @Override
    public List<FlipFitSlot> getSlotList() {
        return List.of();
    }

    @Override
    public List<FlipFitSlot> getSlotByCentreId(String gymCentreId) {
        return List.of();
    }

    @Override
    public void addSlot(FlipFitSlot slot) {

    }

    @Override
    public FlipFitSlot getSlotById(String slotID) {
        return null;
    }

    @Override
    public FlipFitSlot getSlotByIdandCentreId(String slotID, String gymCentreId) {
        return null;
    }
}
