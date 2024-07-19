package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public interface GymOwnerInterfaceDAO {

    public List<FlipFitGymOwner> getGymOwnerList();
    public void setGymOwnerList(List<FlipFitGymOwner> gymOwnerList);
    public void registerGymOwner(FlipFitGymOwner gymOwner);
    public List<FlipFitGymOwner> getPendingGymOwnerList();
    public void sendOwnerApprovalRequest(String gymOwnerId);
    public void setPendingGymOwnerList();
    public void validateGymOwner(String gymOwnerId, int isApproved);
}