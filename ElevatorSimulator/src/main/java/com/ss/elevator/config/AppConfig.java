package com.ss.elevator.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ss.elevator","com.ss.elevator.entity","com.ss.elevator.controller","com.ss.elevator.task" })
public class AppConfig {
	
}