package com.example.userGuide.Forumns;

public class CreateBookmarkForumn {
    private long id;
    private String locationID;
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



    @Override
    public String toString() {
        System.out.println(id);
        return "CreateBookmarkForumn{" +
                "locationED='" + locationID + '\'' +
                ", userID='" + userID + '\'' + '}';
    }
}
