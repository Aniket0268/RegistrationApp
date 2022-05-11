package com.brainworks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brainworks.entities.StateMsterEntity;

public interface StateMasterRepository extends JpaRepository<StateMsterEntity, Integer> {
	
	public List<StateMsterEntity> findByCountryId(Integer countryId);

}
