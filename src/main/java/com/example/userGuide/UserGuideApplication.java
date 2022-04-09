package com.example.userGuide;

import com.example.userGuide.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserGuideApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(UserGuideApplication.class, args);
	}


	private UserRepository userRepository;

	@Override
	public void run(String...args) throws Exception {

	}
}
