package com.example.userGuide.repository;

import com.example.userGuide.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
