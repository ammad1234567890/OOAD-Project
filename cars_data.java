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
public class cars_data {
     public void show_vehicle() throws SQLException{
        String query="Select * from vehicle";
        Statement st=connection.connection.createStatement();
       // ResultSet rs=st.executeQuery(query);
        st.execute(query);
        ResultSet re=st.getResultSet();
                
        if(re!=null){
           while(re.next()){
              System.out.println("Car No for Order: "+re.getString(9));
              System.out.println("Car: "+re.getString(1));
               System.out.println("Price: "+re.getString(2));
               System.out.println("Colour: "+re.getString(3));
               System.out.println("Model: "+re.getString(4));
               System.out.println("engine: "+re.getString(5));
               System.out.println("power: "+re.getString(6));
               System.out.println("priston: "+re.getString(7));
               System.out.println("fuel: "+re.getString(8));
               
           System.out.println("-------------------\n");
    }
    }
     }
     
      public void vehicle_ids() throws SQLException, IOException{
          System.out.print("For Order a car, You need to enter car number: ");
          Scanner input=new Scanner(System.in);
          int order_action= input.nextInt();
        String query="Select vehicle_id from vehicle";
        Statement st=connection.connection.createStatement();
       // ResultSet rs=st.executeQuery(query);
        st.execute(query);
        ResultSet re=st.getResultSet();
                
        if(re!=null){
            java.util.ArrayList alRowData = new java.util.ArrayList();
           while(re.next()){
              
     java.sql.ResultSetMetaData rsmd = re.getMetaData();
     int numberOfColumns = rsmd.getColumnCount();
     for(int columnIndex = 1; columnIndex <= numberOfColumns; columnIndex ++){
          alRowData.add(re.getObject(columnIndex));
     } 

  }
               for(int i=0; i<alRowData.size(); i++){
          if(order_action==(int)alRowData.get(i)){
              order order=new order();
              if(order.addOrder((int)alRowData.get(i), customer.id)==true)
              {
                  System.out.println("Your Order Has been Placed");
              }
              else{
                  System.out.println("Car Number is not Correct");
              }
          }
           } 
    }
    }
}
