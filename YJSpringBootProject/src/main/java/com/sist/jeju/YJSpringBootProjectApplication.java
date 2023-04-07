package com.sist.jeju;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages = {"com.sist.jeju.controller","com.sist.jeju.dao","com.sist.jeju.entity","com.sist.jeju.rest"})
@SpringBootApplication
public class YJSpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(YJSpringBootProjectApplication.class, args);
	}

}
