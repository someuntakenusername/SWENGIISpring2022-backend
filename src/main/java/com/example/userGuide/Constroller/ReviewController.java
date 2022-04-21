package com.example.userGuide.Constroller;


import com.example.userGuide.Forumns.CreateReviewForumn;
import com.example.userGuide.Forumns.CreateUserForumn;
import com.example.userGuide.Service.ReviewService;
import com.example.userGuide.Service.UserService;
import com.example.userGuide.model.Review;
import com.example.userGuide.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("review/")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;


    @GetMapping("/getreviews/{id}")
    public List<Review> getReviews(@PathVariable("id") Object id) {
        return reviewService.getReviews((String)id);
    }

    @RequestMapping(value = "/createreview", method = RequestMethod.POST)
    public Review createReview(@RequestBody CreateReviewForumn createReviewForumn) {
        System.out.println(createReviewForumn);
        return reviewService.createReview(new Review(createReviewForumn.getLocationID(), createReviewForumn.getReviewText()));
    }
}
