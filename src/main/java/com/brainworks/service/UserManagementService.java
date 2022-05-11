package com.brainworks.service;

import java.util.Map;

import com.brainworks.bindings.LoginForm;
import com.brainworks.bindings.RegistrationForm;
import com.brainworks.bindings.UnlockAccountForm;

public interface UserManagementService {
	// LOGIN FORM FUNCTIONALITY
	public String login(LoginForm login);

	// REGISTRATION FORM FUNCTIONALITY
	public Map<Integer, String> loadCountry();

	public Map<Integer, String> loadState(int countryid);

	public Map<Integer, String> loadCity(int stateid);

	public String emailCheck(String email);

	public String saveAccount(RegistrationForm user);

	// UNLOCK ACCOUNT FORM FUNCTIONALITY

	public String unlockacc(UnlockAccountForm unlock);

	// FORGoT PASSWORD FORM FUNCTIONALITY
	public String forgotPass(String email);
}
