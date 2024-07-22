package com.flipkart.dao;

import com.flipkart.bean.FlipFitSlot;
import com.flipkart.constant.SQLConstants;
import com.flipkart.utils.DBConnection;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


/**
 * SlotDAO class implements SlotInterfaceDAO.
 * This class handles data access operations related to slots.
 */


public class SlotDAO implements SlotInterfaceDAO{

    /**
     * Retrieves a list of all slots.
     *
     * @return List of FlipFitSlot objects.
     */

    @Override
    public List<FlipFitSlot> getSlotList() {
        List<FlipFitSlot> slotList = new ArrayList<>();
        try{
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // Establish a connection to the database
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema","root","Poojayadav5*");
//Prepare and execute the SQL query to fetch all slots
            PreparedStatement ps = conn.prepareStatement(SQLConstants.FETCH_ALL_SLOTS);
            ResultSet rs = ps.executeQuery();

            // Process the result set and add slots to the list
            while(rs.next()){
                String slotId = rs.getString("slotId");
                String centreId = rs.getString("gymCenterId");
                LocalTime time = rs.getTime("time").toLocalTime();

                slotList.add(new FlipFitSlot(slotId, time, centreId));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return slotList;
    }
    /**
     * Retrieves a list of slots for a specific gym center.
     *
     * @param gymCentreId The ID of the gym center.
     * @return List of FlipFitSlot objects.
     */
    @Override
    public List<FlipFitSlot> getSlotByCenterId(String gymCentreId) {
        List<FlipFitSlot> slotList = new ArrayList<>();
        try{
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish a connection to the database
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema","root","Poojayadav5*");
//Prepare and execute the SQL query to fetch slots by center ID
            PreparedStatement ps = conn.prepareStatement(SQLConstants.FETCH_SLOT_BY_CENTRE);
            ps.setString(1,gymCentreId);
            ResultSet rs = ps.executeQuery();

            // Process the result set and add slots to the list
            while(rs.next()){
                String slotId = rs.getString("slotId");
                String centreId = rs.getString("gymCenterId");
                LocalTime time = rs.getTime("time").toLocalTime();

                slotList.add(new FlipFitSlot(slotId, time, centreId));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return slotList;
    }
    /**
     * Adds a new slot to the database.
     *
     * @param slot The FlipFitSlot object to be added.
     */
    @Override
    public void addSlot(FlipFitSlot slot) {
        try{
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish a connection to the database
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema","root","Poojayadav5*");

            // Prepare and execute the SQL query to add a new slot
            PreparedStatement ps = conn.prepareStatement(SQLConstants.ADD_SLOT);
            ps.setString(1, slot.getSlotId());
            ps.setString(2, slot.getCenterId());
            ps.setTime(3, java.sql.Time.valueOf(slot.getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Retrieves a slot by its ID.
     *
     * @param slotID The ID of the slot.
     * @return FlipFitSlot object.
     */

    @Override
    public FlipFitSlot getSlotById(String slotID) {
        FlipFitSlot slot = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema","root","Poojayadav5*");
//
            PreparedStatement ps = conn.prepareStatement(SQLConstants.FETCH_SLOT_BY_ID);
            ps.setString(1,slotID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String centreId = rs.getString("gymCenterId");
                LocalTime time = rs.getTime("time").toLocalTime();
                slot = new FlipFitSlot(slotID, time, centreId);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return slot;
    }

    /**
     * Retrieves a slot by its ID and center ID.
     *
     * @param slotID   The ID of the slot.
     * @param centreID The ID of the center.
     * @return FlipFitSlot object.
     */

    @Override
    public FlipFitSlot getSlotByIdandCenterId(String slotID, String centreID) {
        FlipFitSlot slot = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema","root","Poojayadav5*");
//
            PreparedStatement ps = conn.prepareStatement(SQLConstants.FETCH_SLOT_BY_ID_AND_CENTRE_ID);
            ps.setString(1,slotID);
            ps.setString(2,centreID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                LocalTime time = rs.getTime("time").toLocalTime();
                slot = new FlipFitSlot(slotID, time, centreID);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return slot;
    }
}
