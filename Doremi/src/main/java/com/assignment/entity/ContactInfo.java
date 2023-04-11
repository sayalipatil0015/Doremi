package com.assignment.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "ContactInfo ")
public class ContactInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long contactInfoId;
	private String firstName;
	private String lastName;

	@Email
	private String Email;

	private String contactNumber;

	private String age;
	private String gender;


	@OneToOne(cascade = CascadeType.ALL, mappedBy = "contactInfo", fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

}