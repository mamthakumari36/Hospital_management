package org.jsp.hms.exceptionhandler;

import org.jsp.hms.responseStructure.ResponseStructure;
import org.jsp.hms.service.exceptionClass.InvalidIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling 
{
	@ExceptionHandler(InvalidIdException.class)
	public ResponseEntity<?> invalidIdException(InvalidIdException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).message("Invalid Id").body(e.getMessage()).build());
	}

}
