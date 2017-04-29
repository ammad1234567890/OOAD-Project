/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ammad
 */

public class connection {
    public static String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=car_project;";
    public static Connection connection; 
    
    public static boolean connect(){
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection=DriverManager.getConnection(url,"new_ammad","new123");
            return true;
        }
        
        catch(ClassNotFoundException | SQLException ex){
            return false;
        }
    }
    
   
    
    public static ResultSet ExecuteQuery(PreparedStatement sql){
        try{
            return sql.executeQuery();
        }
        catch(SQLException ex){
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        }
        
    }
    public static int ExecuteNonQuery(PreparedStatement prepareStatement){
        try{
            return prepareStatement.executeUpdate();
        }
        catch(SQLException ex){
            return -1;
        }
    }
}
