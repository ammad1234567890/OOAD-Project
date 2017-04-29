/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.spi.DirStateFactory.Result;
import java.sql.Statement;
import java.util.Scanner;
/**
 *
 * @author Ammad
 */
public class Car {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException {
        // TODO code application logic here
        System.out.println(connection.connect());
        Scanner input=new Scanner(System.in);
        clearcon clearscreen=new clearcon();
        customer cust=new customer();
        System.out.println("Welcome to Car Rental Management System ");
       
            System.out.println("1) Sign up \n2) Login");
            
        char action= (char)System.in.read();
        
        if(action=='1'){
            System.out.print("Your First Name: ");
            String fname=input.next();
            System.out.print("Your Last Name: ");
            String lname=input.next();
            System.out.print("Your Phone No: ");
            String phone=input.next();
            System.out.print("Your Resedential Address: ");
            String address=input.next();
            System.out.print("Your CNIC: ");
            String cnic=input.next();
            System.out.print("Your Account Password: ");
            String pass=input.next();
           Boolean status= cust.Signup(fname, lname, phone, address, cnic, pass);
           
           if(status==true)
           {
               System.out.println("Congratulations Your Account has been Created.");
               
           }
           else{
               System.out.println("Please Check your Details");
           
           
        }
            }
    
        
        if(action=='2'){
            System.out.print("Enter your Username: ");
            String username=input.next();
            System.out.print("Enter your Password: ");
            String password=input.next();
          clearscreen.clear();
         System.out.println(cust.login(username, password));  
         while(true){
             // clearscreen.threeclear();
         if(customer.id!=0){
             
             System.out.println("1: Show my Details");
             System.out.println("2: Book a car now");
             System.out.println("3: My Transactions");
             char login_action= (char)System.in.read();
                if(login_action=='1'){
                    cust.show_details();
                    System.out.println("press 0 for update your record");
                    
                    
                    int action2= input.nextInt();
                   if(action2==0){
            System.out.print("Your First Name:");
            String fname=input.next();
            System.out.print("Your Last Name:");
            String lname=input.next();
            System.out.print("Your Phone No");
            String phone=input.next();
            System.out.print("Your Resedential Address");
            String address=input.next();
            System.out.print("Your CNIC");
            String cnic=input.next();
            System.out.print("Your Account Password");
            String pass=input.next();
            Boolean status= cust.Update(fname, lname, phone, address, cnic, pass);
           
                if(status==true)
                {
                  System.out.println("Your Account Details has been updated");
                  continue;
                }
                else{
                    
                    System.out.println("Please Fill all fields");
                   continue;
                }
                }
                   if(action2==9){
                       continue;
                   }
                   
             }
                if(login_action=='2'){
                    cars_data cars=new cars_data();
                    cars.show_vehicle();
                    cars.vehicle_ids();   
                }
         }
       }
        }
    }
    
}
