package com.example.userGuide.model;


public class Location {
    private String id;
    private String imageSrc;
    private String name;
    double rating;
    int reviewCount;
    private int price;
    double distance;
    private String phone;
    private int rank;
    public double latitude;
    public double longitude;

    public Location(String id, String imageSrc, String name, double rating, int reviewCount, int price, double distance, String phone, double latitude, double longitude) {
        this.id = id;
        this.imageSrc = imageSrc;
        this.name = name;
        this.rating = rating;
        this.reviewCount = reviewCount;
        this.price = price;
        this.distance = distance;
        this.phone = phone;
        this.rank = -1;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
