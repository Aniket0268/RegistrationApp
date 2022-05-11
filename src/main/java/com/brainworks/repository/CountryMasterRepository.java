package com.brainworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brainworks.entities.CountryMasterEntity;

public interface CountryMasterRepository extends JpaRepository<CountryMasterEntity, Integer> {

}
