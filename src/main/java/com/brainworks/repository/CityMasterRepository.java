package com.brainworks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brainworks.entities.CityMasterEntity;

public interface CityMasterRepository extends JpaRepository<CityMasterEntity, Integer>{
	public List<CityMasterEntity>findByStateId(Integer stateId);

}
