package com.challenge.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Acceleration;
import com.challenge.entity.User;
import com.challenge.service.impl.AccelerationService;

@RestController
@RequestMapping("acceleration")
public class AccelerationResource {
	
	@Autowired
	AccelerationService accelerationService;
	
	
	@GetMapping("{id}")
	Optional<Acceleration> one(@PathVariable Long id) {
		return accelerationService.findById(id);

	}
	
	@GetMapping()
	List<Acceleration> findByCompanyId(@RequestParam Long companyId) {
		return accelerationService.findByCompanyId(companyId);

	}
	
	
	

}
