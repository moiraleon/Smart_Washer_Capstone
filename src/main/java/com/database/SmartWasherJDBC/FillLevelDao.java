package com.database.SmartWasherJDBC;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class FillLevelDao {

    public void createFillLevel(Double fillLevel){

        try(
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/devices-data?useSSL=false", "root", "pluralsight");
                PreparedStatement statement = connection.prepareStatement("INSERT INTO device_one VALUES(?);")



                ){
            statement.setDouble(1,fillLevel);
            statement.executeUpdate();


        }catch(Exception e){
            e.printStackTrace();
        }

    return;

    }
//SHOWING ALL LOGS ON PAGE
    public List<Double> displayAllFillLevels(){
        List<Double> allFillValues = new ArrayList<>();
        try(
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/devices-data?useSSL=false", "root", "pluralsight");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from device_one");
                ) {
            while (resultSet.next()){
                allFillValues.add(resultSet.getDouble("fill_level"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return allFillValues;
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
