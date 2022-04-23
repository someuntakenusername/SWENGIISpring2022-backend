package com.example.userGuide.model;

import javax.persistence.*;

@Entity
@Table(name = "userlocations")
public class UserLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "cost")
    private int cost;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "userID")
    private Long userID;

    public UserLocation() {

    }

    public UserLocation(int cost, String name, String address, String phone, Long userID) {
        super();
        this.cost = cost;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.userID = userID;
    }

    public Long getUserID() {
        return userID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserID(Long userID) {
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
}
