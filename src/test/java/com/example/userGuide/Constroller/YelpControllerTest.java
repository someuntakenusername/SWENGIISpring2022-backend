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


}