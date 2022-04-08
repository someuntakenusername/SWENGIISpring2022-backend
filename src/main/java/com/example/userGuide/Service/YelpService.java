package com.example.userGuide.Service;

import com.example.userGuide.model.User;
import com.example.userGuide.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class YelpService {

    public String RecAlgorithm(int cost, String rating, String reviews, String contact, String location) throws IOException {
        location = location.replaceAll(" ", "%20");
        URL url = new URL("http://127.0.0.1:8080/http://api.yelp.com/v3/businesses/search?categories=skiresorts&location=" + location + "&limit=50&sort_by=best_match");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setDoOutput(true);
        con.setRequestProperty("Authorization", "Bearer h5ZnJC2Z6QNEZt6iLSxW83zkQr6Obcb6WuP-rlxKw-8xU3mInevlmRnlBrs3M95W6FSR9ORrOslSlEO8YUZOB5wwf6nmplIf2ZBq2GAIXRAZi9JbPvkxEkm3Pn4WYnYx");
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
        return content.toString();
    }

}





