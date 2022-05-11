package com.brainworks.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="STATES_MASTER")
public class StateMsterEntity {
	@Id
	@GeneratedValue
	@Column(name = "STATE_ID")
	private Integer stateId;
	@Column(name = "STATE_NAME")
	private String  stateName;
	@Column(name = "COUNTRY_ID")
	private Integer countryId;
}
