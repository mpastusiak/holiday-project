package com.kodilla.holiday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HolidayApplication extends SpringBootServletInitializer {
//public class HolidayApplication{

	public static void main(String[] args) {
		SpringApplication.run(HolidayApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HolidayApplication.class);
	}

}