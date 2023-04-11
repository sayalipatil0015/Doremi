package com.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.assignment.dto.Response;
import com.assignment.dto.UserDto;
import com.assignment.entity.ContactInfo;
import com.assignment.entity.User;
import com.assignment.error.CustomException;
import com.assignment.error.HttpStatusCode;
import com.assignment.error.Result;
import com.assignment.mapper.ContactInfoMapper;
import com.assignment.mapper.UserMapper;
import com.assignment.repository.ContactInfoRepository;
import com.assignment.repository.UserRepository;

public class UserServiceImpl {
	
	@Autowired
	Result result;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ContactInfoRepository contactInfoRepository;
	
	@Autowired
	private ContactInfoMapper contactInfoMapper;
	
	public Response<User> createNewUser(UserDto userDTO) {
		Response<User> response = new Response<>();
		if(userDTO.getUsername() != null){
			throw new CustomException(
					HttpStatusCode.RESOURCE_ALREADY_EXISTS.getCode(),
					HttpStatusCode.RESOURCE_ALREADY_EXISTS,
					HttpStatusCode.RESOURCE_ALREADY_EXISTS.getMessage(),
					result);
		}

		User user = userMapper.toUser(userDTO);
		User userWithPreEncodePassword = new User(user.getUsername(),user.getPassword(),user.getContactInfo());
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		userWithPreEncodePassword.setId(user.getId());
		ContactInfo contact =contactInfoMapper.dtoToEntity(userDTO.getContactInfoDto());
		contact=contactInfoRepository.save(contact);
		user.setContactInfo(contact);
		userRepository.save(user);
		user.setPassword(userWithPreEncodePassword.getPassword());

		response.setStatusCode(HttpStatusCode.RESOURCE_CREATED_SUCCESSFULLY.getCode());
		response.setMessage(HttpStatusCode.RESOURCE_CREATED_SUCCESSFULLY.getMessage());
		response.setResult(new Result<>(user));
		return response;
	}
	


}
