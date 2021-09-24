package com.database.company_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Driver {
    public static void main(String[] args) {

        try{

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company_data?useSSL=false", "root", "pluralsight");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from Employee");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("FirstName"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
