package com.database.SmartWasherJDBC.DAO;

import com.database.SmartWasherJDBC.model.Device;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DeviceDao {

    public void createFillLevel(String name, Double fillLevel){

        try(
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/devices-data?useSSL=false", "root", "pluralsight");
                PreparedStatement statement = connection.prepareStatement("INSERT INTO device_one (name,fill_value) VALUES(?,?);")



                ){
            statement.setString(1,name);
            statement.setDouble(2,fillLevel);
            statement.executeUpdate();


        }catch(Exception e){
            e.printStackTrace();
        }

    return;

    }
//SHOWING ALL LOGS ON PAGE
    public List<Device> displayAllFillLevels(){
        List<Device> allDevices = new ArrayList<>();
        try(
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/devices-data?useSSL=false", "root", "pluralsight");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from device_one");
                ) {
            while (resultSet.next()){
                Device device = new Device();
                device.setId(resultSet.getInt("id"));
                device.setName(resultSet.getString("name"));
                device.setFillLevel(resultSet.getInt("fill_level"));
                allDevices.add(device);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return allDevices;
    }



    public double getLastFillLevel(){
        List<Double> fillValues = new ArrayList<>();

        try(
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/devices-data?useSSL=false", "root", "pluralsight");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from device_one");
        ){


            while (resultSet.next()) {


                fillValues.add(resultSet.getDouble("fill_level"));

            }
            System.out.println(fillValues.get(fillValues.size()-1));

        } catch (Exception e){
            e.printStackTrace();
        }

        return fillValues.get(fillValues.size()-1);
    }



}
