package com.assignment.error;

public enum HttpStatusCode {

	CONTACTINFO_RETRIVED_SUCCESSFULLY(200,"Contact Info retrived successfully"),
	NO_CONTACTINFO_FOUND(108,"No contact info found"),
	RESOURCE_NOT_FOUND(108, "Does not exist"),
	RESOURCE_CREATED_SUCCESSFULLY(201, "Resource Created Successfully"),  

	RESOURCE_ALREADY_EXISTS(110, "Already exists"),

	NO_ENTRY_FOUND(101,"Resource Not Found");
	
	int code;
	private String message;

	HttpStatusCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}