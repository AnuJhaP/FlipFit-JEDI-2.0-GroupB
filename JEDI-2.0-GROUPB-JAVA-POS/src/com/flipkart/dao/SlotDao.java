package com.flipkart.dao;
import com.flipkart.bean.FlipFitSlot;
import com.flipkart.constant.SQLConstants;
import com.flipkart.utils.DBConnection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;


    public class SlotDao implements SlotInterfaceDao {
        public SlotDao(){
        }

        public List<FlipFitSlot> getSlotList() {
            List<FlipFitSlot> slotList = new ArrayList<>();
            try{
                Connection conn = DBConnection.connect();
                PreparedStatement ps = conn.prepareStatement(SQLConstants.FETCH_ALL_SLOTS);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String slotId = rs.getString("slotId");
                    String centreId = rs.getString("centreId");
                    LocalTime time = rs.getTime("time").toLocalTime();

                    slotList.add(new FlipFitSlot(slotId, time,centreId));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return slotList;
        }

        public List<FlipFitSlot> getSlotByCentreId(String gymCentreId){
            List<FlipFitSlot> slotList = new ArrayList<>();
            try{
                Connection conn = DBConnection.connect();
                PreparedStatement ps = conn.prepareStatement(SQLConstants.FETCH_SLOT_BY_CENTRE);
                ps.setString(1,gymCentreId);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String slotId = rs.getString("slotId");
                    String centreId = rs.getString("centreId");
                    LocalTime time = rs.getTime("time").toLocalTime();

                    slotList.add(new FlipFitSlot(slotId, time,centreId));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return slotList;
        }

        public void addSlot(FlipFitSlot slot){
            try{
                Connection conn = DBConnection.connect();
                PreparedStatement ps = conn.prepareStatement(SQLConstants.ADD_SLOT);
                ps.setString(1, slot.getSlotId());
                ps.setString(2, slot.getCentreID());
                ps.setTime(3, java.sql.Time.valueOf(slot.getTime()));
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public FlipFitSlot getSlotById(String slotID) {
            FlipFitSlot slot = null;
            try{
                Connection conn = DBConnection.connect();
                PreparedStatement ps = conn.prepareStatement(SQLConstants.FETCH_SLOT_BY_ID);
                ps.setString(1,slotID);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String centreId = rs.getString("centreId");
                    LocalTime time = rs.getTime("time").toLocalTime();
                    slot = new FlipFitSlot(slotID,  time , centreId);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return slot;
        }

        public FlipFitSlot getSlotByIdandCentreId(String slotID,String centerId) {
            FlipFitSlot slot = null;
            try{
                Connection conn = DBConnection.connect();
                PreparedStatement ps = conn.prepareStatement(SQLConstants.FETCH_SLOT_BY_ID_AND_CENTRE_ID);
                ps.setString(1,slotID);
                ps.setString(2,centerId);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    LocalTime time = rs.getTime("time").toLocalTime();
                    slot = new FlipFitSlot(slotID,time,centerId);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return slot;
        }
    }
}
