package com.flipkart.business;
import com.flipkart.bean.FlipFitSlot;

import java.util.List;

public interface SlotService {
    List<FlipFitSlot> getAllSlotsByCentre(String centreID);
    FlipFitSlot getSlotByID(String slotID);
    List<FlipFitSlot> getSlotList();
    void addSlotsForGym(String gymCentreId, List<FlipFitSlot> slotList);
    boolean isSlotValid(String slotID,String centreId);
}

