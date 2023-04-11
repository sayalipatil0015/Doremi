package com.assignment.service;

import com.assignment.dto.Response;
import com.assignment.dto.UserDto;
import com.assignment.entity.User;

public interface UserService {

	Response<User> createNewUser(UserDto userDTO);
}
