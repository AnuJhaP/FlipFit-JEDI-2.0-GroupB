package com.flipkart.dao;

import com.flipkart.bean.FlipFitCenter;
import com.flipkart.constant.SQLConstants;
import com.flipkart.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.flipkart.constant.SQLConstants.FETCH_GYM_CENTRE_BY_ID;

public class GymCentreDAO implements GymCentreInterfaceDAO {
    private Connection conn = null;
    private PreparedStatement statement = null;

    public GymCentreDAO() {
    }

    public List<FlipFitCenter> getAllCentresByOwnerId(String gymOwnerId)  {

        List<FlipFitCenter> allGymCentres = new ArrayList<>();
        try {
            conn = DBConnection.connect();
            statement = conn.prepareStatement(SQLConstants.FETCH_GYM_CENTRES_BY_OWNER_ID);
            statement.setString(1, gymOwnerId);

            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                FlipFitCenter gymCentre = new FlipFitCenter(
                        rs.getString("centreId"),
                        rs.getString("ownerId"),
                        rs.getString("centreName"),
                        rs.getString("gstin"),
                        rs.getString("city"),
                        rs.getInt("capacity"),
                        rs.getInt("price")
                );
                gymCentre.setApproved(rs.getInt("isApproved"));
                allGymCentres.add(gymCentre);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return allGymCentres;
    }



    public FlipFitCenter getGymCentreByCentreId(String gymCentreId){
        FlipFitCenter gymCentre = new FlipFitCenter();
        try {
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(FETCH_GYM_CENTRE_BY_ID);
            stmt.setString(1, gymCentreId);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            gymCentre.setGymCentreID(rs.getString("centreId"));
            gymCentre.setOwnerID(rs.getString("ownerId"));
            gymCentre.setGymCenterName(rs.getString("centreName"));
            gymCentre.setGstin(rs.getString("gstin"));
            gymCentre.setCity(rs.getString("city"));
            gymCentre.setCapacity(rs.getInt("capacity"));
            gymCentre.setPrice(rs.getInt("price"));
            gymCentre.setApproved(rs.getInt("isApproved"));
            stmt.close();
        } catch (SQLException exp) {
            exp.printStackTrace();
        }

        return gymCentre;

    }

    public void addGymCentre(FlipFitCenter centre) {
        // call to db api
        try {
            conn = DBConnection.connect();
            System.out.println("Adding gym centre....");

            //    INSERT INTO FlipFit.GymCentre (centreId, ownerId, centreName, gstin, city, capacity, price, isApproved)
            statement = conn.prepareStatement(SQLConstants.ADD_GYM_CENTRE_QUERY);
            statement.setString(1,centre.getGymCentreID());
            statement.setString(2,centre.getOwnerID());
            statement.setString(3, centre.getGymCenterName());
            statement.setString(4,centre.getGstin());
            statement.setString(5, centre.getCity());
            statement.setInt(6, centre.getCapacity());
            statement.setInt(7, centre.getPrice());
            statement.setInt(8, centre.isApproved());

            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<FlipFitCenter> getPendingGymCentreList() {
        List<FlipFitCenter> pendingList = new ArrayList<>();
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching gym centres..");

            statement = conn.prepareStatement(SQLConstants.FETCH_ALL_PENDING_GYM_CENTRES_QUERY);

            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                FlipFitCenter gymCentre = new FlipFitCenter(
                        rs.getString("centreId"),
                        rs.getString("ownerId"),
                        rs.getString("centreName"),
                        rs.getString("gstin"),
                        rs.getString("city"),
                        rs.getInt("capacity"),
                        rs.getInt("price")
                );
                gymCentre.setApproved(rs.getInt("isApproved"));
                pendingList.add(gymCentre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pendingList;
    }

    public void validateGymCentre(String gymCentreId, int isApproved) {
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching gyms centres..");

            statement = conn.prepareStatement(SQLConstants.SQL_APPROVE_GYM_CENTRE_BY_ID_QUERY);
            statement.setInt(1, isApproved);
            statement.setString(2, gymCentreId);
            statement.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendCentreApprovalRequest(String gymCentreId){
        try {
            conn = DBConnection.connect();
            System.out.println("Sending gym centre approval request..");
            // SQL_APPROVE_GYM_CENTRE_BY_ID_QUERY="Update GymCentre Set isApproved=? WHERE centreId=?";
            statement = conn.prepareStatement(SQLConstants.SQL_APPROVE_GYM_CENTRE_BY_ID_QUERY);
            statement.setInt(1,2);
            statement.setString(2, gymCentreId);
            statement.executeUpdate();

        } catch (SQLException se) { se.printStackTrace(); }
        catch (Exception e) { e.printStackTrace(); }
    }

    public List<FlipFitCenter> getGymCentreListByCity(String city) {
        List<FlipFitCenter> allCentreByCity = new ArrayList<>();
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching gyms centres by City..");
            statement = conn.prepareStatement(SQLConstants.FETCH_GYM_CENTRES_BY_CITY);
            statement.setString(1, city);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                FlipFitCenter gymCentre = new FlipFitCenter(
                        rs.getString("centreId"),
                        rs.getString("ownerId"),
                        rs.getString("centreName"),
                        rs.getString("gstin"),
                        rs.getString("city"),
                        rs.getInt("capacity"),
                        rs.getInt("price")
                );
                allCentreByCity.add(gymCentre);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allCentreByCity;
    }
}