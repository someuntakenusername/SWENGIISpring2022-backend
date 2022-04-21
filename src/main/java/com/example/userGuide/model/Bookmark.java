package com.example.userGuide.model;

import javax.persistence.*;

@Entity
@Table(name = "bookmarks")
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "locationID")
    private String locationID;

    @Column(name = "userID")
    private String userID;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Bookmark() {

    }

    public Bookmark(String locationID, String userID) {
        this.locationID = locationID;
        this.userID = userID;
    }
}
