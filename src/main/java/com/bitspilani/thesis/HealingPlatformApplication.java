package com.bitspilani.thesis;

import com.bitspilani.thesis.repository.EventConfigRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableMongoRepositories
@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories(basePackageClasses = EventConfigRepository.class)
@EntityScan("com.bitspilani.thesis.model")
public class HealingPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealingPlatformApplication.class, args);
	}

}
