package com.example.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springcoredemo.common.Coach;
import com.example.springcoredemo.common.VolleyballCoach;

@Configuration
public class SportConfig {

	@Bean("someId")
	public Coach volleyballCoach() {
		return new VolleyballCoach();
	}
}
