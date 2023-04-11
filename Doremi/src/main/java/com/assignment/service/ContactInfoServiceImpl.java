package com.assignment.service;

import java.util.List;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.assignment.dto.ContactInfoDto;
import com.assignment.dto.Response;
import com.assignment.entity.ContactInfo;
import com.assignment.error.CustomException;
import com.assignment.error.HttpStatusCode;
import com.assignment.error.Result;
import com.assignment.mapper.ContactInfoMapper;
import com.assignment.pagination.dto.PaginationResponse;
import com.assignment.repository.ContactInfoRepository;

@Service
public class ContactInfoServiceImpl implements ContactInfoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContactInfoService.class);

	@Autowired
	private ContactInfoRepository contactInfoRepository;

	@Autowired
	private ContactInfoMapper contactInfoMapper;

	@Autowired
	Result result;

	public Response<ContactInfoDto> addContactInfo(ContactInfoDto contactInfoDto) {

		Response<ContactInfoDto> response = new Response<>();
		Result<ContactInfoDto> res = new Result<>();

		if (contactInfoDto.getFirstName().isEmpty() || contactInfoDto.getFirstName().length() == 0) {
			throw new CustomException(HttpStatusCode.NO_CONTACTINFO_FOUND.getCode(),
					HttpStatusCode.NO_CONTACTINFO_FOUND, HttpStatusCode.NO_CONTACTINFO_FOUND.getMessage(), res);
		}
		ContactInfo savedContact = contactInfoRepository.save(contactInfoMapper.dtoToEntity(contactInfoDto));
		response.setStatusCode(HttpStatusCode.RESOURCE_CREATED_SUCCESSFULLY.getCode());
		response.setMessage(HttpStatusCode.RESOURCE_CREATED_SUCCESSFULLY.getMessage());
		response.setResult(new Result<ContactInfoDto>(contactInfoMapper.entityToDto(savedContact)));
		return response;
	}
	
	public Response<PaginationResponse<List<ContactInfoDto>>> getContactInfo(Integer PageNumber, Integer PageSize) {
		Result<PaginationResponse<List<ContactInfoDto>>> res = new Result<>();
		res.setData(null);
		Pageable paging = PageRequest.of(PageNumber, PageSize);
		Response<PaginationResponse<List<ContactInfoDto>>> getListofContacts = new Response<>();
		Page<ContactInfo> list = this.contactInfoRepository.findAll(paging);
		List<ContactInfoDto> contactInfoDtos = contactInfoMapper.entitiesToDtos(list.toList());
		
		//res.setData(contactInfoDtos);
		if (list.getSize() == 0) {
			throw new CustomException(HttpStatusCode.NO_ENTRY_FOUND.getCode(), HttpStatusCode.NO_ENTRY_FOUND,
					HttpStatusCode.NO_ENTRY_FOUND.getMessage(), res);
		}
		PaginationResponse paginationResponse=new PaginationResponse<List<ContactInfoDto>>(contactInfoDtos,list.getTotalPages(),list.getTotalElements());
		res.setData(paginationResponse);
		
		getListofContacts.setStatusCode(200);
		getListofContacts.setResult(res);
		return getListofContacts;
	}

	

}
