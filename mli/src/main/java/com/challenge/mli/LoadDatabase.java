package com.challenge.mli;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
	
	@Bean
	CommandLineRunner initDatabase(SatelliteRepository repository) {
		return args -> {};
	}

}
