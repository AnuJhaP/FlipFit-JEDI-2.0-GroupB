package com.flipkart.business;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public interface AdminService {
    void validateGymCentre(String centerId, boolean isApproved);
    void validateOwner(String ownerId, boolean isApproved);
    List<FlipFitCenter> viewPendingGymCenters();
    List<FlipFitGymOwner> viewPendingGymOwners();
}
