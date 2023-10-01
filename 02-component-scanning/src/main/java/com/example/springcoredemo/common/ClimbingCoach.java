package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class ClimbingCoach implements Coach {
	@Override
	public String getDailyWorkout() {
		return "Climb harder!";
	}
}
