package com.flipkart.dao;

import com.flipkart.bean.Schedule;
import com.flipkart.constant.SQLConstants;
import com.flipkart.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO implements ScheduleInterfaceDAO {

    public void addSchedule( Schedule schedule){
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema","root","Poojayadav5*");

            PreparedStatement ps = conn.prepareStatement(SQLConstants.ADD_SCHEDULE);
            ps.setString(1, schedule.getScheduleID());
            ps.setDate(2, schedule.getDate());
            ps.setString(3, schedule.getSlotID());
            ps.setInt(4, schedule.getAvailability());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public Schedule getSchedule(String scheduleId){
        Schedule schedule = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema","root","Poojayadav5*");
//
            PreparedStatement ps = conn.prepareStatement(SQLConstants.GET_SCHEDULE_BY_ID);
            ps.setString(1, scheduleId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String slotId = rs.getString("slotId");
                int availability = rs.getInt("availability");
                Date date = new Date(rs.getDate("date").getTime());
                schedule = new Schedule(date, slotId, availability);
                schedule.setScheduleID(scheduleId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return schedule;
    }

    public List<Schedule> getAllScheduleByDate(Date date) {
        ArrayList<Schedule> response = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema","root","Poojayadav5*");
//
            PreparedStatement ps = conn.prepareStatement(SQLConstants.GET_SCHEDULES_BY_DATE);
            ps.setDate(1, new java.sql.Date(date.getTime()));
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                String scheduleId = rs.getString("scheduleId");
                String slotId = rs.getString("slotId");
                int availability = rs.getInt("availability");
                Schedule schedule = new Schedule( date, slotId, availability);
                schedule.setScheduleID(scheduleId);
                response.add(schedule);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return response;
    }

    public boolean modifySchedule(String scheduleId,int action){
        //1 for increasing, -1 for decreasing
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema","root","Poojayadav5*");
//
            int availability = getSchedule(scheduleId).getAvailability();
            if(availability < 1 && action == -1){
                return false;
            }
            PreparedStatement ps = conn.prepareStatement(SQLConstants.MODIFY_SCHEDULE_AVAILABILITY);
            ps.setInt(1, availability+action);
            ps.setString(2, scheduleId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}