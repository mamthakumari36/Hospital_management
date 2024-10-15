package org.jsp.hms.service.exceptionClass;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class InvalidIdException extends RuntimeException 
{
	private String message;

	public InvalidIdException(String message) 
	{
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}

}
