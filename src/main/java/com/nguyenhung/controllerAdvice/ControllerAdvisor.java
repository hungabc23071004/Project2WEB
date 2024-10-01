package com.nguyenhung.controllerAdvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nguyenhung.Model.ErrorResponseDTO;

import customerexception.FieldeRequiredException;
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
     @ExceptionHandler(FieldeRequiredException.class)
     public ResponseEntity<Object> handleFieldeRequiredException(
    		 FieldeRequiredException ex, WebRequest request	){
	
    	 
    ErrorResponseDTO errorResponseDTO=new ErrorResponseDTO();
    errorResponseDTO.setError(ex.getMessage());	
    List<String> details=new ArrayList<>();
    details.add("Check lai name hoac numberOfBasement di boi vi bi null");
    errorResponseDTO.setDetail(details);
    return new ResponseEntity<>( errorResponseDTO, HttpStatus.BAD_GATEWAY);
}
}