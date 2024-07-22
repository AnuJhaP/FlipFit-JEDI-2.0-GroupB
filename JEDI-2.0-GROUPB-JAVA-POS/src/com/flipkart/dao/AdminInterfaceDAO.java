package com.flipkart.dao;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.exceptions.UserInvalidException;

import java.util.List;

public interface AdminInterfaceDAO {
    public List<FlipFitGymOwner> getPendingGymOwners();
    public void validateGymOwner(String gymOwnerId, int isApproved);
    public void validateGymCentre(String gymCentreId, int isApproved);
    public List<FlipFitCenter> getPendingGymCentres();
    public boolean isUserValid(String userName, String password);

}
