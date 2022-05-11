package com.brainworks.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brainworks.bindings.LoginForm;
import com.brainworks.bindings.RegistrationForm;
import com.brainworks.service.UserManagementService;

@RestController
public class UserRegRestController {
	@Autowired
	private UserManagementService services;

	@GetMapping("/email/{email}")
	public String emailCheck(@PathVariable("email") String email) {

		return services.emailCheck(email);

	}

	@GetMapping("/countries")
	public Map<Integer, String> getCountries() {

		return services.loadCountry();

	}

	@GetMapping("/states/{countryId}")
	public Map<Integer, String> getStates(@PathVariable("countryId")Integer countryId) {

		return services.loadState(countryId);

	}
	@GetMapping("/cities/{stateId}")
	public Map<Integer, String> getCities(@PathVariable("stateId")Integer StateId) {

		return services.loadCity(StateId);

	}
	@PostMapping("/user")
	public String userReg(@RequestBody RegistrationForm form) {
		return services.saveAccount(form);
	}
	
	
	
}