package com.example.userGuide.Constroller;

import com.example.userGuide.Service.JsonReader;
import com.example.userGuide.Service.PreferenceService;
import com.example.userGuide.Service.YelpService;
import com.example.userGuide.UserGuideApplication;
import com.example.userGuide.model.Location;
import com.example.userGuide.model.Preference;
import com.example.userGuide.repository.PreferenceRepository;
import net.sf.ehcache.Element;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("locations/")
public class YelpController {

    @Autowired
    private PreferenceService preferenceService;

    @GetMapping("/{id}")
    public List<Location> getRecommended(@PathVariable("id") Object id) throws JSONException, IOException {
       Preference pref = preferenceService.getPreference((String) id);
       if (pref != null){
           return RecAlgoOne(Integer.parseInt(pref.cost), pref.rating, pref.reviews, pref.contact, pref.city);
       }else{
           return null;
       }
    }

    @GetMapping("/{cost}/{rating}/{reviews}/{contact}/{location}")
    public List<Location> RecAlgo(@PathVariable("cost") int cost, @PathVariable("rating") String rating, @PathVariable("reviews") String reviews, @PathVariable("contact") String contact, @PathVariable("location") String location) throws IOException, JSONException {
        return getLocations(cost, rating, reviews, contact, location);
    }

    public List<Location> RecAlgoOne(int cost, String rating, String reviews, String contact, String location) throws IOException, JSONException {
        return getLocations(cost, rating, reviews, contact, location);
    }

    private List<Location> getLocations(int cost, String rating, String reviews, String contact, String location) throws IOException, JSONException {
        if (UserGuideApplication.locationCache == null || !UserGuideApplication.locationCache.isKeyInCache(cost + rating + reviews + contact + location)) {
            String output = new YelpService().RecAlgorithm(cost, rating, reviews, contact, location);
            JSONObject json = JsonReader.readJsonFromString(output);
            JSONArray businesses = (JSONArray) json.get("businesses");
            List<Location> locations = new ArrayList<>();
            for (int i = 0; i < businesses.length(); i++) {
                JSONObject loc = businesses.getJSONObject(i);
                String id;
                String imageSrc;
                String name;
                double ratings;
                int reviewCount;
                int prices;
                double distance;
                String phone;
                try {
                    id = loc.getString("id");
                } catch (JSONException e) {
                    id = null;
                }
                try {
                    imageSrc = loc.getString("image_url");
                } catch (JSONException e) {
                    imageSrc = null;
                }
                try {
                    name = loc.getString("name");
                } catch (JSONException e) {
                    name = null;
                }
                try {
                    ratings = loc.getDouble("rating");
                } catch (JSONException e) {
                    ratings = -1;
                }
                try {
                    reviewCount = loc.getInt("review_count");
                } catch (JSONException e) {
                    reviewCount = -1;
                }
                try {
                    prices = loc.getString("price").length();
                } catch (JSONException e) {
                    prices = -1;
                }
                try {
                    distance = loc.getDouble("distance");
                } catch (JSONException e) {
                    distance = -1;
                }
                try {
                    phone = loc.getString("phone");
                } catch (JSONException e) {
                    phone = null;
                }
                double latitude = -1;
                double longitude = -1;
                try {
                    JSONObject coordinates = loc.getJSONObject("coordinates");
                    latitude = coordinates.getDouble("latitude");
                    longitude = coordinates.getDouble("longitude");
                } catch (JSONException e) {
                    phone = null;
                }

                locations.add(new Location(id, imageSrc, name, ratings, reviewCount, prices, distance, phone, latitude, longitude));
            }

            locations.sort((O1, O2) -> {
                int ap = -1;
                int bp = -1;
                if (O1.getPrice() == -1) {
                    ap = 1000;
                } else {
                    ap = Math.abs(O1.getPrice() - cost);
                }
                if (O2.getPrice() == -1) {
                    bp = 1000;
                } else {
                    bp = Math.abs(O2.getPrice() - cost);
                }
                return Integer.compare(ap, bp);
            });
            List<Location> priceSort = new ArrayList<>(locations);
            locations.sort((O1, O2) -> {
                double ap = -1;
                double bp = -1;
                if (O1.getRating() == -1) {
                    ap = 1000;
                } else {
                    ap = Math.abs(O1.getRating() - Double.parseDouble(rating));
                }
                if (O2.getRating() == -1) {
                    bp = 1000;
                } else {
                    bp = Math.abs(O2.getRating() - Double.parseDouble(rating));

                }
                return Double.compare(ap, bp);
            });
            List<Location> ratingSort = new ArrayList<>(locations);
            locations.sort((O1, O2) -> {
                Boolean asmall = false;
                Boolean bsmall = false;

                if (O1.getReviewCount() < Double.parseDouble(reviews)) {
                    asmall = true;
                }
                if (O2.getReviewCount() < Double.parseDouble(reviews)) {
                    bsmall = true;
                }

                if (asmall && bsmall) {
                    return 0;
                } else if (asmall) {
                    return -1;
                } else if (bsmall) {
                    return 1;
                } else {
                    return Integer.compare(O2.getReviewCount(), O1.getReviewCount());
                }
            });
            List<Location> countSort = new ArrayList<>(locations);
            locations.sort(Comparator.comparingDouble(Location::getDistance));
            List<Location> distanceSort = new ArrayList<>(locations);
            for (int i = 0; i < locations.size(); i++) {
                String id = locations.get(i).getId();
                double distanceRank = distanceSort.indexOf(locations.get(i));
                double priceRank = priceSort.indexOf(locations.get(i));
                double ratingRank = ratingSort.indexOf(locations.get(i));
                double countRank = countSort.indexOf(locations.get(i));
                double distanceScore = (distanceRank / locations.size()) * 100;
                double priceScore = (priceRank / locations.size()) * 100;
                double ratingScore = (ratingRank / locations.size()) * 100;
                double countScore = (countRank / locations.size()) * 100;
                double totalRank = (distanceScore + countScore + ratingScore + priceScore);
                if (locations.get(i).getPhone() != null && !Objects.equals(contact, "no")) {
                    totalRank += 5;
                }
                if (totalRank / 4 > 100) {
                    totalRank = 400;
                }
                locations.get(i).setRank((int) Math.round(totalRank / 4));

            }
            locations.sort((O1, O2) -> Integer.compare(O2.getRank(), O1.getRank()));
            UserGuideApplication.locationCache.put(new Element(cost + rating + reviews + contact + location, locations));
            return locations;
        }else{
            System.out.println("In Cache");
            return (List<Location>)UserGuideApplication.locationCache.get(cost + rating + reviews + contact + location).getObjectValue();
        }
    }

}
