package com.flipkart.business;
import com.flipkart.bean.FlipFitSlot;

import java.util.List;

public interface GymCenterService {

    public boolean deleteGymCentre(int centreId);
    public List<FlipFitSlot> viewAvailableSlots(int centreId);
}
