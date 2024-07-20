package com.flipkart.business;

import com.flipkart.dao.GymOwnerDAO;

import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public class GymOwnerServiceImpl implements GymOwnerService {
    private static GymOwnerDAO gymOwnerDAO = new GymOwnerDAO();
    public void requestGymOwnerApproval(String gymOwnerId) {
        gymOwnerDAO.sendOwnerApprovalRequest(gymOwnerId);
    }

    public List<FlipFitGymOwner> viewAllGymOwners() {
        return gymOwnerDAO.getGymOwnerList();
    }

    public boolean loginGymOwner(String username,String password){
        return gymOwnerDAO.loginGymOwner(username,password);
    }

    public void registerGymOwner(String userId,String userName, String password, String email, String panNumber,String cardNumber) {
        gymOwnerDAO.registerGymOwner(new FlipFitGymOwner(userId,userName,email,password,panNumber,cardNumber));
    }
}