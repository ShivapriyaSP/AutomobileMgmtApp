package com.mindtree.AutomobileManagement.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(AutomobileMgmtException.class)
	public ResponseEntity<?> exceptionHandler(AutomobileMgmtException exception, WebRequest request)
	{
		ErrorDetails errordetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errordetails, HttpStatus.BAD_REQUEST);
	}
}
