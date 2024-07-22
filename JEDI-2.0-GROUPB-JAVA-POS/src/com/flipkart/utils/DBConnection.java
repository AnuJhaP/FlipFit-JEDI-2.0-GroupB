package com.flipkart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
//
//public class DBConnection {
//    private static Connection singleInstance = null;
//    public static Connection connect() throws SQLException {
//
//        if(singleInstance ==null){
////            System.out.println("Connecting to DB....");
//            // Register the jdbc driver
//            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
////                    String url = "jdbc:mysql://localhost:3306/F";//flipfit is the name of database 3306 is the port no. of mysql
//
//                Properties newProp = new Properties();
//
//                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema","root","Poojayadav5*");
////                System.out.println("Database Connected");
//                singleInstance = connection;
//                return connection;
//            }
//            catch (ClassNotFoundException ex){
//                System.err.println("Could not find jdbc driver.");
////                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//        }
//        else{
//            return singleInstance;
//        }
//
//
//    }
//}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnection
{
    public static Connection connect() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit-schema","root","Poojayadav5*");

            PreparedStatement stmt=con.prepareStatement("insert into emp values(?,?)");
            stmt.setInt(1,101);//1 specifies the first parameter in the query
            stmt.setString(2,"Ratan");

            int i=stmt.executeUpdate();
            System.out.println(i+" records inserted");

            con.close();

        }catch(Exception e){ System.out.println(e);}
        return null;
    }
}