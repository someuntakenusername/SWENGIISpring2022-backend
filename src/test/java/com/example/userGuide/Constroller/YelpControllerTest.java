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
    PreferenceService preferenceService;

    @Autowired
    YelpService yelpService;

    @Test
    public void createNewLocation() {
        UserLocation newLoc;
        assertNotNull(newLoc = yelpService.createLocation(0, "Song's Hut", "1 Bear Place", "1234567890", 12345));
        yelpService.removeUserLocation(Long.toString(newLoc.getId()), Long.toString(newLoc.getUserID()));
    }

    @Test
    public void createDuplicateLocation() {
        UserLocation newLoc1 = yelpService.createLocation(0, "Song's Hut", "1 Bear Place", "1234567890", 12345);
        UserLocation newLoc2;
        assertNotNull(newLoc2 = yelpService.createLocation(0, "Song's Hut", "1 Bear Place", "1234567890", 12345));
        yelpService.removeUserLocation(Long.toString(newLoc1.getId()), Long.toString(newLoc1.getUserID()));
        yelpService.removeUserLocation(Long.toString(newLoc2.getId()), Long.toString(newLoc2.getUserID()));
    }

    @Test
    public void getUserLocationsNotEmpty() {
        UserLocation newLoc = yelpService.createLocation(0, "Song's Hut", "1 Bear Place", "1234567890", 12345);
        assertThat(!yelpService.getUserLocations(Long.toString(newLoc.getUserID())).isEmpty());
        yelpService.removeUserLocation(Long.toString(newLoc.getId()), Long.toString(newLoc.getUserID()));
    }

    @Test
    public void getUserLocationsEmpty() {
        assertThat(yelpService.getUserLocations("0").isEmpty());
    }

    @Test
    public void removeExistingUserLocation() {
        UserLocation newLoc = yelpService.createLocation(0, "Song's Hut", "1 Bear Place", "1234567890", 12345);
        assertNotNull(yelpService.removeUserLocation(Long.toString(newLoc.getId()), Long.toString(newLoc.getUserID())));
    }

    @Test
    public void removeNonExistingUserLocation() {
        assertNull(yelpService.removeUserLocation("0", "0"));
    }

    @Test
    public void removeDuplicateLocation() {
        UserLocation newLoc1 = yelpService.createLocation(0, "Song's Hut", "1 Bear Place", "1234567890", 12345);
        UserLocation newLoc2 = yelpService.createLocation(0, "Song's Hut", "1 Bear Place", "1234567890", 12345);
        yelpService.removeUserLocation(Long.toString(newLoc1.getId()), Long.toString(newLoc1.getUserID()));
        assertNotNull(yelpService.removeUserLocation(Long.toString(newLoc2.getId()), Long.toString(newLoc2.getUserID())));
    }
}