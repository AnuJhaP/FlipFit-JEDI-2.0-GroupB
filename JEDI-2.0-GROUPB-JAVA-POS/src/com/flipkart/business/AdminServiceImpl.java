package com.flipkart.business;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;
import com.flipkart.dao.AdminDAO;
import com.flipkart.dao.AdminInterfaceDAO;
import com.flipkart.exceptions.UserInvalidException;

import java.util.ArrayList;

public class AdminServiceImpl implements AdminService {

        AdminInterfaceDAO adminDAO  = new AdminDAO();

        private List<FlipFitGymOwner> pendinGymOwnerList = new ArrayList<>();
        private List<FlipFitCenter> pendinGymCentreList = new ArrayList<>();

        public void validateCenter(String gymCentreId, int isApproved){
            adminDAO.validateGymCentre(gymCentreId,isApproved);
        }

        public void validateOwner(String gymOwnerId, int isApprove){
            adminDAO.validateGymOwner(gymOwnerId,isApprove);
        }

        public List<FlipFitCenter> viewPendingCentres(){
            pendinGymCentreList = adminDAO.getPendingGymCentres();
            return pendinGymCentreList;
        }

        public List<FlipFitGymOwner> viewPendingOwners(){
            System.out.println("Pending Gym Owner  Request Approvals: ");
            pendinGymOwnerList = adminDAO.getPendingGymOwners();
            return pendinGymOwnerList;
        }

    @Override
    public boolean isUserValid(String userName, String password) {
        return adminDAO.isUserValid(userName,password);
    }

}
