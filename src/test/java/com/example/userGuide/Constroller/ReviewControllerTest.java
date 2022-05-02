package com.example.userGuide.Constroller;

import com.example.userGuide.Service.ReviewService;
import com.example.userGuide.model.Location;
import com.example.userGuide.model.Review;
import com.example.userGuide.model.User;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ReviewControllerTest {
    @Autowired
    private ReviewService reviewService;
    private Location l = new Location();

    
    @BeforeAll
    public void setTestLocation() {
        l.setId("TestLocation");
    }


    /*
    @BeforeAll
    public void setupTests() {
        l.setId("TestLocation");
        reviewService.createReview(new Review("TestLocation", "This is a test review"));
    }
    */
    @Test
    public void createReview() {
        assertThat(
                reviewService.createReview(new Review("TestLocation", "This is a test review"))
                .equals(new User("john", "doe", "iamthechowderman@hotmail.org", "rosebud"))
        );
    }

    @Test
     public void getReviews() {
        reviewService.createReview(new Review("TestLocation", "This is a test review"));
        assertThat(
                reviewService.getReviews("TestLocation").get(0).equals(new Review("TestLocation", "This is a test review"))
        );
    }


}

