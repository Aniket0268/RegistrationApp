package com.brainworks.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brainworks.bindings.LoginForm;
import com.brainworks.service.UserManagementService;

@RestController
public class LoginRestController {
	@Autowired
	private UserManagementService services;
	@PostMapping("/login")
	public String login(@RequestBody LoginForm form) {
		
		return services.login(form);
	}
}
