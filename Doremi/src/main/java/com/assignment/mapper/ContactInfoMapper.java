package com.assignment.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.assignment.dto.ContactInfoDto;
import com.assignment.entity.ContactInfo;


@Component
public class ContactInfoMapper {

	ModelMapper modelMapper= new ModelMapper();

	// DTO to entity Mapping
	public ContactInfo dtoToEntity(ContactInfoDto contactInfoDto) {
		return modelMapper.map(contactInfoDto, ContactInfo.class);
	}
	//entity to DTO Mapping
	public ContactInfoDto entityToDto(ContactInfo contactInfo) {
		return modelMapper.map(contactInfo, ContactInfoDto.class);
	}
	
	public List<ContactInfoDto> entitiesToDtos(List<ContactInfo> contactInfo) {
        return contactInfo.stream().filter(Objects::nonNull).map(this::entityToDto).collect(Collectors.toList());
    }

}
