package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;

@RestController
@RequestMapping("challenge")
public class ChallengeResource {
	
	@Autowired
	ChallengeService challengeService;
	
	@GetMapping
	List<Challenge> findByAccelerationIdAndUserId(@RequestParam Long accelerationId,@RequestParam Long userId) {
		return challengeService.findByAccelerationIdAndUserId(accelerationId, userId);	
		
	}
}
