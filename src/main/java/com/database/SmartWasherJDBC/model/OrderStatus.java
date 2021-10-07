package com.database.SmartWasherJDBC.model;

public class OrderStatus {

    private int id;
    private int deviceId;
    private boolean orderPlaced;
    private boolean orderFulfilled;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public boolean isOrderPlaced() {
        return orderPlaced;
    }

    public void setOrderPlaced(boolean orderPlaced) {
        this.orderPlaced = orderPlaced;
    }

    public boolean isOrderFulfilled() {
        return orderFulfilled;
    }

    public void setOrderFulfilled(boolean orderFulfilled) {
        this.orderFulfilled = orderFulfilled;
    }
}
