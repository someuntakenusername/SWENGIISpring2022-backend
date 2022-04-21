package com.example.userGuide.Forumns;

public class CreateReviewForumn {
    private String locationID;
    private String reviewText;

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    @Override
    public String toString() {
        return "CreateReviewForumn{" +
                "locationID='" + locationID + '\'' +
                ", reviewText='" + reviewText + '\'' + '}';
    }
}
