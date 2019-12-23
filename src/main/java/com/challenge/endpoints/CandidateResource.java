package com.challenge.endpoints;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;

@RestController
@RequestMapping("candidate")
public class CandidateResource {

	@Autowired
	CandidateService candidateService;

	@Autowired
	CandidateMapper candidateMapper;

	@GetMapping("{userId}/{companyId}/{accelerationId}")
	public ResponseEntity<CandidateDTO> one(@PathVariable Long userId, @PathVariable Long companyId,
			@PathVariable Long accelerationId) {

		Optional<Candidate> cadidates = candidateService.findById(userId, companyId, accelerationId);
		if (cadidates.isPresent()) {

			return ResponseEntity.ok(candidateMapper.map(cadidates.get()));
		}
		return ResponseEntity.ok(new CandidateDTO());
	}

	@GetMapping
	public ResponseEntity<List<CandidateDTO>> findByParam(@RequestParam(required = false) Long accelerationId,
			@RequestParam(required = false) Long companyId) {
		if (accelerationId != null) {
			List<Candidate> cadidates = candidateService.findByAccelerationId(accelerationId);
			return ResponseEntity.ok(candidateMapper.map(cadidates));
		}
		if (companyId != null) {
			List<Candidate> cadidates = candidateService.findByCompanyId(companyId);
			return ResponseEntity.ok(candidateMapper.map(cadidates));
		}
		return ResponseEntity.ok(new ArrayList<>());
	}
}
