package com.example.userGuide.repository;

import com.example.userGuide.model.Preference;
import com.example.userGuide.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
