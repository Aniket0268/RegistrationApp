package com.brainworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brainworks.entities.UserRegistrationEntity;

public interface UserRegistrationRepository extends JpaRepository<UserRegistrationEntity, Integer> {
	public UserRegistrationEntity findByEmailAndPassword(String email, String password);
	
	public UserRegistrationEntity findByEmail(String email);
}
