package com.flipkart.dao;

import com.flipkart.bean.FlipFitSlot;
import com.flipkart.constant.SQLConstants;
import com.flipkart.utils.DBConnection;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SlotDAO implements SlotInterfaceDAO{
    @Override
    public List<FlipFitSlot> getSlotList() {
        List<FlipFitSlot> slotList = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema","root","Poojayadav5*");
//
            PreparedStatement ps = conn.prepareStatement(SQLConstants.FETCH_ALL_SLOTS);
            ResultSet rs = ps.executeQuery();
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

    @Override
    public List<FlipFitSlot> getSlotByCenterId(String gymCentreId) {
        List<FlipFitSlot> slotList = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema","root","Poojayadav5*");
//
            PreparedStatement ps = conn.prepareStatement(SQLConstants.FETCH_SLOT_BY_CENTRE);
            ps.setString(1,gymCentreId);
            ResultSet rs = ps.executeQuery();
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

    @Override
    public void addSlot(FlipFitSlot slot) {
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema","root","Poojayadav5*");
//
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
