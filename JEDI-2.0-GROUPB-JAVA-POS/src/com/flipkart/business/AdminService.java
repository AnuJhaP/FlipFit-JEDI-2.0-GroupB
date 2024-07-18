package com.flipkart.business;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public interface AdminService {
    void validateCenter(String centerId, Boolean isApproved);
    void validateOwner(String ownerId, Boolean isApproved);
    List<FlipFitCenter> viewPendingCentres();
    List<FlipFitGymOwner> viewPendingGymOwners();
}
