package com.database.SmartWasherJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StartWash {

    @Autowired
    FillLevelDao fillLevelDao;

    @RequestMapping(method = RequestMethod.GET, value = "/start-wash")
    public String startWash() {
       Double lastValue = fillLevelDao.getLastFillLevel();

        if (lastValue <=8){
            System.out.println("Level detected below min fill quantity. Order placed");

        } else if (lastValue>8) {
            System.out.println("Detergent level sufficient. Wash started.");

        }
        fillLevelDao.createFillLevel(lastValue-4);
        return "StartWash.html";
    }




}
