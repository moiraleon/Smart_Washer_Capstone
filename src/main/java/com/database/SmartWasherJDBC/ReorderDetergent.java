package com.database.SmartWasherJDBC;

import javax.swing.*;

public class ReorderDetergent {
    private boolean orderInProcess;
    private boolean orderNotInProcess;



    public ReorderDetergent( boolean unordered, boolean purchased,boolean orderUnsuccessful, boolean inTransit){
        this.orderInProcess = orderInProcess;
        this.orderNotInProcess =orderNotInProcess;

    }

    public boolean isOrderInProcess() {
        return orderInProcess;
    }

    public void setOrderInProcess(boolean orderInProcess) {
        this.orderInProcess = orderInProcess;
    }

    public boolean isOrderNotInProcess() {
        return orderNotInProcess;
    }

    public void setOrderNotInProcess(boolean orderNotInProcess) {
        this.orderNotInProcess = orderNotInProcess;
    }
    //for reset button to be toggled when soap recieved
//    public void resetOrderStatus(boolean orderInProcess, boolean orderNotInProcess) extends JFrame implements void ActionListener {
//        //set orderInProcess to false
//        //set orderNotInProcess to true
//        }
//
//    }

//    public void preventDuplicateOrders(boolean orderInProcess, boolean orderNotInProcess){
//
//        if (orderInProcess == true && fillLevel <=8){
//            //do nothing
//
//        }else if(orderNotInProcess == true && fill level <=8){
//          //set orderInProcess to true and alert user order was placed//not actually ordering at this time
//
//        }
//
//    }

}
