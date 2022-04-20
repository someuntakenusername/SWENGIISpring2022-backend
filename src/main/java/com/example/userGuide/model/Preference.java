package com.example.userGuide.model;

import javax.persistence.*;

@Entity
@Table(name = "preferences")
public class Preference {
    @Id
    public long id;

    @Column(name = "cost")
    public String cost;

    @Column(name = "rating")
    public String rating;

    @Column(name = "reviews")
    public String reviews;

    @Column(name = "contact")
    public String contact;

    @Column(name = "city")
    public String city;

    public Preference(String id, String cost, String rating, String reviews, String contact, String city) {
        this.id = Long.parseLong(id);
        this.cost = cost;
        this.rating = rating;
        this.reviews = reviews;
        this.contact = contact;
        this.city = city;
    }

    public Preference() {

    }
}
