package com.flipkart.business;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;
import com.flipkart.dao.AdminDAO;
import com.flipkart.dao.AdminInterfaceDAO;

import java.util.ArrayList;

/**
 * @author JEDI-02
 * Service implementation for Admin Operations
 *
 */

public class AdminServiceImpl implements AdminService {

        AdminInterfaceDAO adminDAO  = new AdminDAO();

        private List<FlipFitGymOwner> pendinGymOwnerList = new ArrayList<>();
        private List<FlipFitCenter> pendinGymCentreList = new ArrayList<>();

        /**
         * Validates a gym center based on its ID and approval status.
         *
         * @param gymCentreId ID of the gym center to validate
         * @param isApproved  Approval status (1 for approved, 0 for not approved)
         */
        public void validateCenter(String gymCentreId, int isApproved){
            adminDAO.validateGymCentre(gymCentreId,isApproved);
        }

        /**
         * Validates a gym owner based on their ID and approval status.
         *
         * @param gymOwnerId ID of the gym owner to validate
         * @param isApprove  Approval status (1 for approved, 0 for not approved)
         */
        public void validateOwner(String gymOwnerId, int isApprove){
            adminDAO.validateGymOwner(gymOwnerId,isApprove);
        }

        /**
         * Retrieves and returns a list of pending gym centers.
         *
         * @return List of pending gym centers
         */
        public List<FlipFitCenter> viewPendingCentres(){
            pendinGymCentreList = adminDAO.getPendingGymCentres();
            return pendinGymCentreList;
        }

        /**
         * Retrieves and returns a list of pending gym owners.
         *
         * @return List of pending gym owners
         */
        public List<FlipFitGymOwner> viewPendingOwners(){
            System.out.println("Pending Gym Owner  Request Approvals: ");
            pendinGymOwnerList = adminDAO.getPendingGymOwners();
            return pendinGymOwnerList;
        }

    }
