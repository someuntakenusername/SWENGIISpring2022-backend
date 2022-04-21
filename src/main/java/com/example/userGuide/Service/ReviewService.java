package com.example.userGuide.Service;

import com.example.userGuide.model.Review;
import com.example.userGuide.model.User;
import com.example.userGuide.repository.ReviewRepository;
import com.example.userGuide.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getReviews(String locationID) {
        List<Review> all = this.reviewRepository.findAll();
        List<Review> toReturn = new ArrayList<>();
        for (Review review : all) {
            if (review.getLocationID().equals(locationID)) {
                toReturn.add(review);
            }
        }
        return toReturn;
    }

    public Review createReview(Review review){
        System.out.println(review);
        return reviewRepository.save(review);
    }
}
