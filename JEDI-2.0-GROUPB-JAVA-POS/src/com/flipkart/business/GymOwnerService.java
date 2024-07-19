package com.flipkart.business;

import com.flipkart.bean.FlipFitGymOwner;

import java.util.ArrayList;
import java.util.List;

public interface GymOwnerService {
    void requestGymOwnerApproval(String gymOwnerId);
    ArrayList<FlipFitGymOwner> viewAllGymOwners();
    boolean loginGymOwner(String userId, String password);

    void registerGymOwner(String userId,String userName, String password, String email, String panNumber,String cardNumber);
}
