package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.SubmissionDTO;
import com.challenge.entity.Submission;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;

@RestController
@RequestMapping("submission")
public class SubmissionResource {
	@Autowired
	SubmissionService submissionService;
	@Autowired
	SubmissionMapper submissionMapper;
	
	
	@GetMapping
	ResponseEntity<List<SubmissionDTO>> findByChallengeIdAndAccelerationId(@RequestParam Long challengeId,@RequestParam Long accelerationId) {
		List<Submission> submissions = submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
		List<SubmissionDTO> submissionsDTO= submissionMapper.map(submissions);
		return ResponseEntity.ok(submissionsDTO);
		
		
	}
	/*@GetMapping
	ResponseEntity<List<Submission>> findAll() {
		return ResponseEntity.ok(submissionService.findAll());
		
	}*/
	

}
