package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.assignment.entity.ContactInfo;


@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long> {
	
	ContactInfo getContactInfoBycontactNumber(String contactNo);
	
	

}
