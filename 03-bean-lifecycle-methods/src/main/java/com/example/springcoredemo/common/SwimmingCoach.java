package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach{
	@Override
	public String getDailyWorkout() {
		return "Swim 10 mins!";
	}
}
