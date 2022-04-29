package com.example.userGuide.Constroller;

import com.example.userGuide.Service.ReviewService;
import com.example.userGuide.model.Location;
import com.example.userGuide.model.Review;
import com.example.userGuide.model.User;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ReviewControllerTest {
    @Autowired
    private ReviewService reviewService;
    private Location l = new Location();

    @Before
    public void setTestLocation() {
        l.setId("TestLocation");
    }

    @Test
    void createReview() {
        assertThat(
                reviewService.createReview(new Review("TestLocation", "This is a test review"))
                .equals(new User("john", "doe", "iamthechowderman@hotmail.org", "rosebud"))
        );
    }

    @Test
     void getReviews() {
        reviewService.createReview(new Review("TestLocation", "This is a test review"));
        assertThat(
                reviewService.getReviews("TestLocation").get(0).equals(new Review("TestLocation", "This is a test review"))
        );
    }


}

