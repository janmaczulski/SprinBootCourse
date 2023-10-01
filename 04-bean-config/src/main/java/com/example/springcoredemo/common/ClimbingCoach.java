package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class ClimbingCoach implements Coach {

	@PostConstruct
	public void doMyStartupStuff(){
		System.out.println("PostConstruct method");
	}

	@PreDestroy
	public void doMyPreDestroyStuff() {
		System.out.println("PreDestroy method");
	}
	@Override
	public String getDailyWorkout() {
		return "Climb harder!";
	}
}
