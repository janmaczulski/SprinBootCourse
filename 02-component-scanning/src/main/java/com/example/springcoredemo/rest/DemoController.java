package com.example.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springcoredemo.common.Coach;
@RestController
public class DemoController {

	private Coach myCoach;

	@Autowired
	public DemoController(@Qualifier("climbingCoach") Coach theCoach){
		myCoach = theCoach;
	}

	@GetMapping("/getworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}

}
