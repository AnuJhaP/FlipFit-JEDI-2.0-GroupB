package com.flipkart.business;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//public class AdminServiceImpl implements AdminService {
//    private List<FlipFitGymOwner> pendinGymOwnerList = new ArrayList<>();
//    private List<FlipFitCenter> pendinGymCentreList = new ArrayList<>();
//
//    public void validateGymCentre(String gymCentreId,boolean isApproved){
//        adminDAO.validateGymCentre(gymCentreId,isApproved);
//    }
//
//    public void approveGymOwner(String gymOwnerId,int isApprove){
//        adminDAO.validateGymOwner(gymOwnerId,isApprove);
//    }
//
//    public List<FlipFitCenter> viewPendingGymCentres(){
//        pendinGymCentreList = adminDAO.getPendingGymCentres();
//        return pendinGymCentreList;
//    }
//
//    public List<FlipFitGymOwner> viewPendingGymOwners(){
//        System.out.println("Viewing pending Gym Owner Approvals: ");
//        pendinGymOwnerList = adminDAO.getPendingGymOwners();
//        return pendinGymOwnerList;
//    }
//}
public class AdminServiceImpl implements AdminService {
    private List<FlipFitGymOwner> pendingGymOwnerList = new ArrayList<>();
    private List<FlipFitCenter> pendingGymCentreList = new ArrayList<>();

    // Assume in-memory storage instead of DAO
    private HashMap<String, FlipFitCenter> gymCentreMap = new HashMap<>();
    private HashMap<String, FlipFitGymOwner> gymOwnerMap = new HashMap<>();

    public void validateGymCentre(String gymCentreId, boolean isApproved) {
        // Update in-memory storage
        FlipFitCenter gymCentre = gymCentreMap.get(gymCentreId);
        if (gymCentre != null) {
            gymCentre.setIsApproved(isApproved);
            gymCentreMap.put(gymCentreId, gymCentre);
        }
    }

    public void validateOwner(String gymOwnerId, boolean isApprove) {
        // Update in-memory storage
        FlipFitGymOwner gymOwner = gymOwnerMap.get(gymOwnerId);
        if (gymOwner != null) {
            gymOwner.setApproved(isApprove == true);
            gymOwnerMap.put(gymOwnerId, gymOwner);
        }
    }

    public List<FlipFitCenter> viewPendingGymCenters() {
        return new ArrayList<>(pendingGymCentreList);
    }

    public List<FlipFitGymOwner> viewPendingGymOwners() {
        // Return in-memory list
        return new ArrayList<>(pendingGymOwnerList);
    }
}
