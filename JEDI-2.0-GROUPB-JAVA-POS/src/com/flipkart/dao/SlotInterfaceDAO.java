package com.flipkart.dao;

import com.flipkart.bean.FlipFitSlot;

import java.util.List;

public interface SlotInterfaceDAO {
    public List<FlipFitSlot> getSlotList();
    public List<FlipFitSlot> getSlotByCentreId(String gymCentreId);
    public void addSlot(FlipFitSlot slot);
    public FlipFitSlot getSlotById(String slotID);
    public FlipFitSlot getSlotByIdandCentreId(String slotID,String gymCentreId);
}
