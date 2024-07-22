package com.flipkart.business;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public interface AdminService {
    void validateCenter(String centerId, int isApproved);
    void validateOwner(String ownerId, int isApproved);
    List<FlipFitCenter> viewPendingCentres();
    List<FlipFitGymOwner> viewPendingOwners();
    boolean isUserValid(String userName, String password);

}
