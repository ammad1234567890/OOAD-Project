/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Ammad
 */
public class customer {
    public static int id;
    private String fname;
    private String lname;
    private String phone;
    private String address;
    private String cnic;
    private String pass;
    
    public Boolean Signup(String fname,String lname,String phone, String address, String cnic,String pass) throws SQLException{
        this.fname=fname;
        this.lname=lname;
        this.address=address;
        this.phone=phone;
        this.cnic=cnic;
        this.pass=pass;
        
        Statement st=connection.connection.createStatement();
        try{
        st.executeUpdate("INSERT INTO user_details(user_firstname,user_lastname,user_phone,user_address,user_cnic,user_pass) VALUES ('"+this.fname+"','"+this.lname+"','"+this.phone+"',"+this.address+",'"+this.cnic+"','"+this.pass+"')");
       //st.executeUpdate("INSERT INTO user_details(user_firstname,user_lastname,user_phone,user_address,user_cnic,user_pass) VALUES ('Ammad','Baig','3352257370','Naz','234234234','pass123')");
         return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public String login(String username,String pass) throws SQLException{
       String query="Select * from user_details where user_firstname='"+username+"' AND user_pass='"+pass+"'";
       //String query="Select * from user_details where user_firstname='Ammad' AND user_pass='Ammad111'";
        Statement st=connection.connection.createStatement();
       // ResultSet rs=st.executeQuery(query);
        st.execute(query);
        ResultSet re=st.getResultSet();
                
        if(re!=null){
           while(re.next()){
               this.id = re.getInt(1);   
            } 
           if(this.id!=0){
               return "Welcome to your portal Mr. "+username;
           }
           return "Wrong Username or Password";
        } 
        else{
            return " ";
        }
    }
    
    public void show_details() throws SQLException{
        String query="Select * from user_details where user_id='"+this.id+"'";
        Statement st=connection.connection.createStatement();
       // ResultSet rs=st.executeQuery(query);
        st.execute(query);
        ResultSet re=st.getResultSet();
                
        if(re!=null){
           while(re.next()){
               System.out.println("First Name: "+re.getString(2));
               System.out.println("Last Name: "+re.getString(3));
               System.out.println("Phone No: "+re.getString(4));
               System.out.println("Resedential Address"+re.getString(5));
               System.out.println("CNIC No"+re.getString(6));
            } 
    }
    }
        
        
            public Boolean Update(String fname,String lname,String phone, String address, String cnic,String pass) throws SQLException{
        this.fname=fname;
        this.lname=lname;
        this.address=address;
        this.phone=phone;
        this.cnic=cnic;
        this.pass=pass;
        
        Statement st=connection.connection.createStatement();
        try{
        st.executeUpdate("Update user_details set user_firstname='"+this.fname+"',user_lastname='"+this.lname+"',user_phone='"+this.phone+"',user_address='"+this.address+"',user_cnic='"+this.cnic+"',user_pass='"+this.pass+"' where user_id='"+this.id+"'");
        //st.executeUpdate("INSERT INTO user_details(user_firstname,user_lastname,user_phone,user_address,user_cnic,user_pass) VALUES ('asd','sdasd','asd','sda','asda','sadas')");
         return true;
        }
        catch(Exception e){
            return false;
        }
    }
            
   
    
   
}
