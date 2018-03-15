package com.revature.batch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EditBatchException  extends RuntimeException{
	
	private static final long serialVersionUID = 3105113186614509667L;
	
	private final String message;
	
	public EditBatchException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}