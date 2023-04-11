package com.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data @RequiredArgsConstructor
@AllArgsConstructor

public class UserDto {
	 private String username;
	 private Boolean isActivate;
	 private ContactInfoDto contactInfoDto;
}
