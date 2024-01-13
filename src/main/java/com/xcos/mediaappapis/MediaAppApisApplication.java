package com.xcos.mediaappapis;

import com.xcos.mediaappapis.repository.MediaPostRepository;
import com.xcos.mediaappapis.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MediaAppApisApplication  {

	public static void main(String[] args) {
		SpringApplication.run(MediaAppApisApplication.class, args);
	}




}
