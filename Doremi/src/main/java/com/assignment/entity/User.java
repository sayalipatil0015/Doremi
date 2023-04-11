package com.assignment.entity;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="user_details")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	//@Column
	//private Boolean isEnabled;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		
		
	}
	public User(String username, String password,ContactInfo contactInfo) {
		this.username = username;
		this.password = password;
		this.contactInfo=contactInfo;
		
	}

	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "contactInfoId")
    private ContactInfo contactInfo;
	
}