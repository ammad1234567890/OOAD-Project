/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/**
 *
 * @author Ammad
 */
public class order {
    
    public boolean addOrder(int vehicle_id,int user_id) throws SQLException{
         
        Statement st=connection.connection.createStatement();
        try{
        st.executeUpdate("Insert into order_details(cust_id,car_id) values('"+vehicle_id+"','"+user_id+"')");
        //st.executeUpdate("INSERT INTO user_details(user_firstname,user_lastname,user_phone,user_address,user_cnic,user_pass) VALUES ('asd','sdasd','asd','sda','asda','sadas')");
         return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
