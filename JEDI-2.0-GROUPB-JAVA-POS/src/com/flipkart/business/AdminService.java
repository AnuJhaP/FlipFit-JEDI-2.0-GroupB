package com.flipkart.business;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public interface AdminService {
    void validateCenter(int centerId, Boolean isApproved);
    void validateOwner(int ownerId, Boolean isApproved);
    List<FlipFitCenter> viewPendingCentres();
    List<FlipFitGymOwner> viewPendingGymOwners();
}
