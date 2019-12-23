package com.challenge.endpoints;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;

@RestController
@RequestMapping("user")
public class UserResource {

	@Autowired
	UserService userService;

	@GetMapping("{id}")
	Optional<User> one(@PathVariable Long id) {

		return userService.findById(id);

	}

	@GetMapping
	ResponseEntity<List<User>> findByAccelerationName(@RequestParam(required = false) String accelerationName,
			@RequestParam(required = false) Long companyId) {
		if (accelerationName != null) {
			return ResponseEntity.ok(userService.findByAccelerationName(accelerationName));

		}
		if (companyId != null) {
			return ResponseEntity.ok(userService.findByCompanyId(companyId));
		}
		return ResponseEntity.ok(new ArrayList<>());
	}

}
