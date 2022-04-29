package com.example.userGuide.Forumns;

import javax.persistence.Column;

public class EditLocationForumn {
    private String name;
    private String address;
    private String phone;
    private int cost;
    private long userID;
    private long locID;

    public long getLocID() {
        return locID;
    }

    public void setLocID(long locID) {
        this.locID = locID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CreateLocationForumn{" + "cost='" + cost + '\'' +
                "name='" + name + '\'' +
                ", address='" + address + '\'' + ", phone='" + phone + '\'' + ", userID='" + userID + '\'' + ", locID='" + locID + '\'' + + '}';
    }
}
