package com.well.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = {"com.well.cache","com.well.datasource","com.well.datasource.impl" })
@PropertySource("classpath:config.properties")
public class AppConfig {
	
	@Value("${cache.eviction.strategy}")
	private String evictionStrategy;
	
	@Value("${cache.eviction.time}")
	private String evictionTime;
	
	@Bean
	public AppProperties appProperties() {

		AppProperties properties = new AppProperties();
		properties.setEvictionStrategy(evictionStrategy);
		properties.setEvictionTime(evictionTime);
		return properties;
	}
	
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		
		return new PropertySourcesPlaceholderConfigurer();
	}
}