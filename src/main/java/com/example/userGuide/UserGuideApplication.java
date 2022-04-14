package com.example.userGuide;

import com.example.userGuide.repository.UserRepository;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserGuideApplication implements CommandLineRunner{
	public static CacheManager cache;
	public static Cache locationCache;
	public static void main(String[] args) {
		cache = CacheManager.getInstance();
		cache.addCacheIfAbsent("locationCache");

		locationCache = cache.getCache("locationCache");
		SpringApplication.run(UserGuideApplication.class, args);
	}


	private UserRepository userRepository;

	@Override
	public void run(String...args) throws Exception {

	}
}
