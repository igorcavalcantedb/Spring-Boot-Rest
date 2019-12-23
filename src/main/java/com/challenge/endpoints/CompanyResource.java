package com.challenge.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.service.impl.CompanyService;
import com.challenge.entity.Company;
@RestController
@RequestMapping("company")
public class CompanyResource {
	@Autowired
	CompanyService companyService;
	
	@GetMapping("{id}")
	Optional<Company> one(@PathVariable Long id) {
		
		return companyService.findById(id);
	}
	
	@GetMapping
	List<Company> findByUserIdOrAccelerationId(@RequestParam(required = false) Long userId,@RequestParam(required = false) Long accelerationId) {
		if(userId!= null) {
			return companyService.findByUserId(userId);
		}
		if(accelerationId != null) {
			return companyService.findByAccelerationId(accelerationId);
		}
		return null;
	}
	

}
