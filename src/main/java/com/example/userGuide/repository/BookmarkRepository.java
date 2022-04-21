package com.example.userGuide.repository;

import com.example.userGuide.model.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

}
