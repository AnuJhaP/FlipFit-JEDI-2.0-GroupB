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

import static com.flipkart.constant.SQLConstants.*;

/**
 * DAO class for handling operations related to gym centers in the Flipkart system.
 */
public class GymCentreDAO implements GymCentreInterfaceDAO {

    private Connection conn = null;
    private PreparedStatement statement = null;

    /**
     * Default constructor for GymCentreDAO.
     */
    public GymCentreDAO() {
    }

    /**
     * Retrieves all gym centers owned by a specific owner.
     *
     * @param gymOwnerId ID of the owner whose gym centers are to be retrieved
     * @return List of FlipFitCenter objects representing gym centers owned by the owner
     */
    public List<FlipFitCenter> getAllCentresByOwnerId(String gymOwnerId) {
        List<FlipFitCenter> allGymCentres = new ArrayList<>();
        try {
            conn = DBConnection.connect();
            statement = conn.prepareStatement(SQLConstants.FETCH_GYM_CENTRES_BY_OWNER_ID);
            statement.setString(1, gymOwnerId);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allGymCentres;
    }

    /**
     * Retrieves details of a gym center by its ID.
     *
     * @param gymCentreId ID of the gym center
     * @return FlipFitCenter object representing the gym center
     */
    public FlipFitCenter getGymCentreByCentreId(String gymCentreId) {
        FlipFitCenter gymCentre = new FlipFitCenter();
        try {
            conn = DBConnection.connect();
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

    /**
     * Adds a new gym center to the database.
     *
     * @param centre FlipFitCenter object representing the gym center to be added
     */
    public void addGymCentre(FlipFitCenter centre) {
        try {
            conn = DBConnection.connect();
            statement = conn.prepareStatement(SQLConstants.ADD_GYM_CENTRE_QUERY);
            statement.setString(1, centre.getGymCentreID());
            statement.setString(2, centre.getOwnerID());
            statement.setString(3, centre.getGymCenterName());
            statement.setString(4, centre.getGstin());
            statement.setString(5, centre.getCity());
            statement.setInt(6, centre.getCapacity());
            statement.setInt(7, centre.getPrice());
            statement.setInt(8, centre.isApproved());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves a list of pending gym centers awaiting approval.
     *
     * @return List of FlipFitCenter objects representing pending gym centers
     */
    public List<FlipFitCenter> getPendingGymCentreList() {
        List<FlipFitCenter> pendingList = new ArrayList<>();
        try {
            conn = DBConnection.connect();
            statement = conn.prepareStatement(SQLConstants.FETCH_ALL_PENDING_GYM_CENTRES_QUERY);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pendingList;
    }

    /**
     * Approves or rejects a gym center by updating its approval status.
     *
     * @param gymCentreId ID of the gym center
     * @param isApproved  Approval status (1 for approved, 0 for pending, 2 for rejected)
     */
    public void validateGymCentre(String gymCentreId, int isApproved) {
        try {
            conn = DBConnection.connect();
            statement = conn.prepareStatement(SQLConstants.SQL_APPROVE_GYM_CENTRE_BY_ID_QUERY);
            statement.setInt(1, isApproved);
            statement.setString(2, gymCentreId);
            statement.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    /**
     * Sends an approval request for a gym center.
     *
     * @param gymCentreId ID of the gym center
     */
    public void sendCentreApprovalRequest(String gymCentreId) {
        try {
            conn = DBConnection.connect();
            statement = conn.prepareStatement(SQLConstants.SQL_APPROVE_GYM_CENTRE_BY_ID_QUERY);
            statement.setInt(1, 2); // 2 represents pending approval
            statement.setString(2, gymCentreId);
            statement.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    /**
     * Retrieves a list of gym centers by city.
     *
     * @param city City name
     * @return List of FlipFitCenter objects representing gym centers in the city
     */
    public List<FlipFitCenter> getGymCentreListByCity(String city) {
        List<FlipFitCenter> allCentreByCity = new ArrayList<>();
        try {
            conn = DBConnection.connect();
            statement = conn.prepareStatement(SQLConstants.FETCH_GYM_CENTRES_BY_CITY);
            statement.setString(1, city);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
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
        }
        return allCentreByCity;
    }
}
