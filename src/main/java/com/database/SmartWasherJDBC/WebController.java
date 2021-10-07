package com.database.SmartWasherJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    FillLevelDao fillLevelDao;


    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String getHomePage(){
        return "home.html";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/start-wash")
    public String startWashPage() {
        return "StartWash.html";
    }

    @PostMapping("/start-wash")
    public String startWash(Model model, @RequestParam String action){
        Double lastValue = fillLevelDao.getLastFillLevel();

        if (lastValue <=8 && action.equals("start-wash")){
            System.out.println("Level detected below min fill quantity. Order placed");

        } else if (lastValue>8 && action.equals("start-wash")) {
            System.out.println("Detergent level sufficient. Wash started.");

        }

        fillLevelDao.createFillLevel(lastValue-4);
        System.out.println("start wash button clicked");
        return "StartWash.html";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/logs")
    public String getLogsPage(){
        return "logs.html";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/account")
    public String getAccountPage(){
        return "account.html";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sign-up")
    public String getSignUpPage(){
        return "sign-up.html";
    }

}
