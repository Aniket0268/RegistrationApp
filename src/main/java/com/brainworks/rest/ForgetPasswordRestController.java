package com.brainworks.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.brainworks.service.UserManagementService;
@RestController
public class ForgetPasswordRestController {
	@Autowired
	UserManagementService services;
	@GetMapping("/forgotPwd/{email}")
	public String forgotPwd(@PathVariable String email) {
		return services.forgotPass(email);
	}

}
