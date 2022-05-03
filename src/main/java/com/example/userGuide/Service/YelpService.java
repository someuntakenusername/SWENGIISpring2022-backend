package com.example.userGuide.Service;

import com.example.userGuide.model.User;
import com.example.userGuide.model.UserLocation;
import com.example.userGuide.repository.UserLocationRepository;
import com.example.userGuide.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class YelpService {

    @Autowired
    UserLocationRepository userLocationRepository;

    public UserLocation createLocation(int cost, String name, String address, String phone, long userID){
        return userLocationRepository.save(new UserLocation(cost, name, address, phone, userID));
    }

    public List<UserLocation> getUserLocations(String userID){
        Long userIDs = Long.parseLong(userID);
        List<UserLocation> all = userLocationRepository.findAll();
        List<UserLocation> toReturn = new ArrayList<>();
        for (UserLocation userLocation : all) {
            if (userLocation.getUserID().equals(userIDs)) {
                toReturn.add(userLocation);
            }
        }
        return toReturn;
    }

    public UserLocation removeUserLocation(String locationID, String userID){
        Long locationIDs = Long.parseLong(locationID);
        Long userIDs = Long.parseLong(userID);
        List<UserLocation> all = userLocationRepository.findAll();
        UserLocation toReturn = null;
        for (UserLocation userLocation : all) {
            if (userLocation.getUserID().equals(userIDs) && userLocation.getId() == locationIDs) {
                toReturn = userLocation;
                userLocationRepository.delete(userLocation);
            }
        }
        return toReturn;
    }

    public String RecAlgorithm(int cost, String rating, String reviews, String contact, String location) throws IOException {
        location = location.replaceAll(" ", "%20");
        URL url = new URL("https://blueflannel-cors.herokuapp.com/http://api.yelp.com/v3/businesses/search?categories=skiresorts&location=" + location + "&limit=50&sort_by=best_match");
        return getYelpQuery(url);
    }


    public String RecAlgorithm(String location) throws IOException {
        location = location.replaceAll(" ", "%20");
        URL url = new URL("https://blueflannel-cors.herokuapp.com/http://api.yelp.com/v3/businesses/search?categories=skiresorts&location=" + location + "&limit=50&sort_by=best_match");
        return getYelpQuery(url);
    }



    public String getById(String id) throws IOException {
        URL url = new URL("https://blueflannel-cors.herokuapp.com/http://api.yelp.com/v3/businesses/" + id);
        return getYelpQuery(url);
    }

    private String getYelpQuery(URL url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setDoOutput(true);
        con.setRequestProperty("Authorization", "Bearer N6RH9ZOhmNSpb1-Jp6Qflwv7U_7Sn1mrQ6JmAjCDC-mnscN-8W-s3dhJvEdwuY4PxjsfcwLxk8nZnv8l-vFfMHdGrD0Q3GYXty7VoFrM3lRglhjY44cAMdCuzmlxYnYx");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        System.out.println(content.toString());
        return content.toString();
    }

}





