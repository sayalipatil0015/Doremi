package com.assignment.service;

import java.util.List;


import com.assignment.dto.ContactInfoDto;
import com.assignment.dto.Response;
import com.assignment.pagination.dto.PaginationResponse;

public interface ContactInfoService {

	Response<ContactInfoDto> addContactInfo(ContactInfoDto contactInfoDto);
	
	Response<PaginationResponse<List<ContactInfoDto>>> getContactInfo(Integer PageNumber, Integer PageSize);

}
