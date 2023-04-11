package com.assignment.dto;

import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfoDto {
	private String firstName;
	private String lastName;

	@Email
	private String Email;

	private String contactNumber;

	private String age;
	private String gender;

}
