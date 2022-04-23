package com.example.userGuide.Constroller;

import com.example.userGuide.Service.BookmarkService;
import com.example.userGuide.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.userGuide.Service","com.example.userGuide.repository","com.example.userGuide.model"})
public class BookmarkConstrollerConfig {
}
