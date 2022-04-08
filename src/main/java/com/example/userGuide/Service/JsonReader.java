package com.example.userGuide.Service;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class JsonReader {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromString(String url) throws IOException, JSONException {
        String jsonText = readAll(new BufferedReader(new StringReader(url)));
        return new JSONObject(jsonText);

    }
}
