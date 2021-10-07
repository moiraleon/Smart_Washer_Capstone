package com.database.SmartWasherJDBC;

public class ReorderDetergent {
    private boolean unordered;
    private boolean purchased;
    private boolean orderUnsuccessful;
    private boolean inTransit;


    public ReorderDetergent( boolean unordered, boolean purchased,boolean orderUnsuccessful, boolean inTransit){
        this.unordered = unordered;
        this.purchased =purchased;
        this.orderUnsuccessful =orderUnsuccessful;
        this.inTransit = inTransit;
    }

    public boolean isUnordered() {
        return unordered;
    }

    public void setUnordered(boolean unordered) {
        this.unordered = unordered;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    public boolean isOrderUnsuccessful() {
        return orderUnsuccessful;
    }

    public void setOrderUnsuccessful(boolean orderUnsuccessful) {
        this.orderUnsuccessful = orderUnsuccessful;
    }

    public boolean isInTransit() {
        return inTransit;
    }

    public void setInTransit(boolean inTransit) {
        this.inTransit = inTransit;
    }
}
