package com.flipkart.business;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public class AdminServiceImpl implements AdminService {

    @Override
    public void validateCenter(String centerId, Boolean isApproved) {

    }

    @Override
    public void validateOwner(String ownerId, Boolean isApproved) {

    }

    @Override
    public List<FlipFitCenter> viewPendingCentres() {
        return List.of();
    }

    @Override
    public List<FlipFitGymOwner> viewPendingGymOwners() {
        return List.of();
    }
}
