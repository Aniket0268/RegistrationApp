package com.brainworks.bindings;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class RegistrationForm {
	private String fname;
	private String lname;
	private String email;
	private String password;
	private Long phno;
   	private LocalDate dob;
	private String gender;
	private Integer cityId;
	private Integer stateId;
	private Integer countryId;
	
	
	

}
