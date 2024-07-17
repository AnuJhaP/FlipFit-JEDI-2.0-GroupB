package com.flipkart.business;

import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public class GymOwnerServiceImpl implements GymOwnerService {

    @Override
    public void requestGymOwnerApproval(String gymOwnerId) {

    }

    @Override
    public List<FlipFitGymOwner> viewAllGymOwners() {
        return List.of();
    }

    @Override
    public boolean loginGymOwner(String userId, String password) {
        return false;
    }

    @Override
    public void registerGymOwner(String userId, String userName, String password, String email, String panNumber, String cardNumber) {

    }
}