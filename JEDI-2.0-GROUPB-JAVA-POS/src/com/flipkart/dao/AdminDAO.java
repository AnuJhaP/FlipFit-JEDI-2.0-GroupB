package com.flipkart.dao;
import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitGymOwner;
import java.util.List;
    public class AdminDAO implements AdminInterfaceDAO {

        private static GymOwnerInterfaceDAO gymOwnerDAO = new GymOwnerDAO();
        private static GymCentreInterfaceDAO gymCentreDAO = new GymCentreDAO();


        public List<FlipFitGymOwner> getPendingGymOwners() {
            return gymOwnerDAO.getPendingGymOwnerList();
        }

        public void validateGymOwner(String gymOwnerId, int isApproved) {
            gymOwnerDAO.validateGymOwner(gymOwnerId, isApproved);
        }

        public void validateGymCentre(String gymCentreId, int isApproved) {
            gymCentreDAO.validateGymCentre(gymCentreId,isApproved);
        }

        public List<FlipFitCenter> getPendingGymCentres() {
            return gymCentreDAO.getPendingGymCentreList();
        }

    }