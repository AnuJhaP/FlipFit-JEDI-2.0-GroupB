package com.flipkart.business;

import com.flipkart.dao.GymOwnerDAO;

import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public class GymOwnerServiceImpl implements GymOwnerService {
    private static GymOwnerDAO gymOwnerDAO = new GymOwnerDAO();
    @Override
    public void requestGymOwnerApproval(String gymOwnerId) {
        gymOwnerDAO.sendOwnerApprovalRequest(gymOwnerId);
    }

    @Override
    public List<FlipFitGymOwner> viewAllGymOwners() {

        return gymOwnerDAO.getGymOwnerList();
    }

    @Override
    public boolean loginGymOwner(String userId, String password) {

        return gymOwnerDAO.loginGymOwner(userId,password);
    }

    @Override
    public void registerGymOwner(String userId, String userName, String password, String email, String panNumber, String cardNumber) {
        gymOwnerDAO.registerGymOwner(new FlipFitGymOwner(userId,userName,email,password,panNumber,cardNumber));
    }
}