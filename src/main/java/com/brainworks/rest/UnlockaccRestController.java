package com.brainworks.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brainworks.bindings.UnlockAccountForm;
import com.brainworks.service.UserManagementService;
@RestController
public class UnlockaccRestController {
	@Autowired
	UserManagementService services;
	
	@PostMapping("/unlock")
	public String UnlockAcc(@RequestBody UnlockAccountForm unlockForm) {
		return services.unlockacc(unlockForm);
		
	}

}
