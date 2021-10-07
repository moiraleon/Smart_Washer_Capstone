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
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/start-wash")
    public String startWashPage() {
        return "StartWash";
    }

    @PostMapping("/start-wash")
    @ResponseBody
    public Boolean startWash(Model model){
        Double lastValue = fillLevelDao.getLastFillLevel();

        if (lastValue <=8 && lastValue>=4){
            System.out.println("Level detected below min fill quantity. Order placed");
            fillLevelDao.createFillLevel(lastValue-4);

        } else if (lastValue>8) {
            System.out.println("Detergent level sufficient. Wash started.");
            fillLevelDao.createFillLevel(lastValue-4);

        } else if(lastValue <4){
            System.out.println("Wash not completed. Insufficient detergent.");


        }

//        fillLevelDao.createFillLevel(lastValue-4);
        return true;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/logs")
    public String getLogsPage(Model model){
        List<Double> pageDisplayLogs = fillLevelDao.displayAllFillLevels();
        model.addAttribute("entry",pageDisplayLogs);
        return "logs";
    }



    @RequestMapping(method = RequestMethod.GET, value = "/account")
    public String getAccountPage(){
        return "account";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sign-up")
    public String getSignUpPage(){
        return "sign-up";
    }

}
