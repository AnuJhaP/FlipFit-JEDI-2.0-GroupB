package com.flipkart.dao;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public interface AdminInterfaceDao {
    public List<FlipFitGymOwner> getPendingGymOwners();
    public void validateGymOwner(String gymOwnerId, int isApproved);
    public void validateGymCentre(String gymCentreId, int isApproved);
    public List<FlipFitCenter> getPendingGymCentres();
}
