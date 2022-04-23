package com.example.userGuide.Constroller;

import com.example.userGuide.Service.PreferenceService;
import com.example.userGuide.Service.YelpService;
import com.example.userGuide.model.UserLocation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class YelpControllerTest {
    @Autowired
    private PreferenceService preferenceService;

    @Autowired
    private YelpService yelpService;

    @Test
    void searchLocation() throws IOException {
        assertThat(yelpService.RecAlgorithm("telluride colorado")).isNotNull();
    }

    @Test
    void getUserLocations() {
        for(UserLocation u : yelpService.getUserLocations("0")){
            System.out.println(u);
        };
    }

    @Test
    void removeUserLocation() {
    }

    @Test
    void getById() {
    }

    @Test
    void getRecommended() {
    }

    @Test
    void recAlgo() {
    }

    @Test
    void recAlgoOne() {
    }

    @Test
    void createLocation() {
    }
}