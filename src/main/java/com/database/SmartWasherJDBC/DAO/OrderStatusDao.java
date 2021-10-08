package com.database.SmartWasherJDBC.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class OrderStatusDao {

    public void resetOrderStatus(Boolean orderPlaced, Boolean orderFulfilled){

        try(
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/devices-data?useSSL=false", "root", "pluralsight");
                PreparedStatement statement = connection.prepareStatement("INSERT INTO device_one (order_placed,order_fulfilled) VALUES('false','true');")//is this how I would reset them?



        ){
            statement.setBoolean(1,orderPlaced);
            statement.setBoolean(2,orderFulfilled);
            statement.executeUpdate();


        }catch(Exception e){
            e.printStackTrace();
        }

        return;

    }

}
