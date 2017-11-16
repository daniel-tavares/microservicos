package br.com.usuario.exceptions;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.usuario.response.ResponseException;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler{

	
	@Autowired
	ResponseException responseException;

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ResponseException> handleResourceNotFoundException(ResourceNotFoundException ex) {
		responseException.title("Não Localizado")
		  	       					    .message(ex.getMessage()+" - id:"+ex.getResourceId())
		  	       					    .timestamp(new Date().getTime())
		  	       					    .developerMessage(ex.getClass().getName()+"-"+ex.getCause())
										.status(HttpStatus.NOT_FOUND.value());
		
	
		return new ResponseEntity<ResponseException>(responseException,HttpStatus.NOT_FOUND);
	}

	
		
		@ExceptionHandler(ResourceFoundException.class)
		public ResponseEntity<ResponseException> handleResourceFoundException(ResourceFoundException ex) {
		responseException.title("Já Cadastrado")
		  	       					    .message(ex.getMessage())
		  	       					    .timestamp(new Date().getTime())
		  	       					    .developerMessage(ex.getClass().getName())
										.status(HttpStatus.NOT_FOUND.value());
		
		
		return new ResponseEntity<>(responseException,HttpStatus.NOT_FOUND);
	}
	
	

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		    
		List<FieldError> erros = ex.getBindingResult().getFieldErrors(); 
	
		responseException.title("Dados Incorretos")
		  	     .status(status.value())
		  	     .message(erros.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(",")) +" - "+erros.stream().map(FieldError::getField).collect(Collectors.joining(",")))
		  	     .status(status.value())
		  	     .timestamp(new Date().getTime())
		  	     .developerMessage(ex.getMessage()+" - "+ex.getClass().getName());
		  
		return new ResponseEntity<Object>(responseException,status);
	}
	
	
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		  responseException.title("Erro interno")
 	     .status(status.value())
 	     .message(ex.getMessage())
 	     .timestamp(new Date().getTime())
 	     .developerMessage(ex.getClass().getName()).status(status.value());
 	    
		return new ResponseEntity<Object>(responseException, headers, status);
	}
	
}