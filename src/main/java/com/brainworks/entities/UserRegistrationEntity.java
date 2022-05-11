package com.brainworks.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "USER_MASTER")
public class UserRegistrationEntity {
	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Integer userId;
	@Column(name = "FIRST_NAME")
	private String fname;
	@Column(name = "LASTNAME")
	private String lname;
	@Column(name = "EMAIL", unique = true)
	private String email;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "PHONE")
	private long phno;
	@Column(name = "DOB")
	private LocalDate dob;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "TEMPPWD")
	private String tempPassword;
	@Column(name = "STATUS")
	private String accStatus;
	@Column(name = "CREATED_DATE", updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;
	@Column(name = "UPDATED_DATE", insertable = false)
	@UpdateTimestamp
	private LocalDate updateDate;
	private Integer cityId;
	private Integer stateId;
	private Integer countryId;
}
