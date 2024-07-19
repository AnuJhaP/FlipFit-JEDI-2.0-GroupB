package com.flipkart.business;

import com.flipkart.bean.FlipFitGymOwner;

import java.util.ArrayList;

//public class GymOwnerServiceImpl implements GymOwnerService {
//
////    private static GymOwnerDAO gymOwnerDAO = new GymOwnerDAO();
//    public void requestGymOwnerApproval(String gymOwnerId) {
//        gymOwnerDAO.sendOwnerApprovalRequest(gymOwnerId);
//    }
//
//    public List<FlipFitGymOwner> viewAllGymOwners() {
//        return gymOwnerDAO.getGymOwnerList();
//    }
//
//    public boolean loginGymOwner(String username,String password){
//        return gymOwnerDAO.loginGymOwner(username,password);
//    }
//
//    public void registerGymOwner(String userId,String userName, String password, String email, String panNumber,String cardNumber) {
//        gymOwnerDAO.registerGymOwner(new FlipFitGymOwner(userId,userName,email,password,panNumber));
//    }
//}
public class GymOwnerServiceImpl implements GymOwnerService {

    private ArrayList<FlipFitGymOwner> gymOwners = new ArrayList<>();

    public void requestGymOwnerApproval(String gymOwnerId) {
        for (FlipFitGymOwner owner : gymOwners) {
            if (owner.getUserId().equals(gymOwnerId)) {
//                owner.setStatus("Pending Approval");
                break;
            }
        }
    }

    public ArrayList<FlipFitGymOwner> viewAllGymOwners() {
        return new ArrayList<>(gymOwners);
    }

    public boolean loginGymOwner(String username, String password) {
        for (FlipFitGymOwner owner : gymOwners) {
            if (owner.getUserName().equals(username) && owner.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void registerGymOwner(String userId, String userName, String password, String email, String panNumber, String cardNumber) {
        FlipFitGymOwner newOwner = new FlipFitGymOwner(userId, userName, email, password, panNumber);
        gymOwners.add(newOwner);
    }
}
