package com.example.userGuide.Forumns;

import javax.persistence.Column;
import javax.persistence.Id;

public class CreatePreferenceForumn {

    private long id;

    private String cost;

    private String rating;

    private String reviews;

    private String contact;

    private String city;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        System.out.println(id);
        return "CreatePreferenceForumn{" +
                "id='" + id + '\'' +
                ", cost='" + cost + '\'' + ", rating='" + rating + '\'' + ", contact='" + contact + '\'' + ", city='" + city + '\'' +
                ", reviews='" + reviews + '\'' + '}';
    }
}
