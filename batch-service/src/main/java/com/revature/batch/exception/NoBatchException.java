package com.revature.batch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoBatchException extends Exception{

	private static final long serialVersionUID = -6360752869028537565L;

	private final String message;
	
	public NoBatchException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
