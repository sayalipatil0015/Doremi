package com.assignment.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="viewer")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class viewer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String music;

	@Column(nullable = false)
	private String video;
	
	@Column(nullable = false)
	private String prodcast;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "viewer", fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

}
