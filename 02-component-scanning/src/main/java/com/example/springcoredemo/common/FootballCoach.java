package com.example.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {
	@Override
	public String getDailyWorkout() {
		return "Play smarter";
	}
}
