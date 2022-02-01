package br.com.siscadselecao.service.exceptions;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResoucerExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<StandartError> entityNotFound(EntityNotFoundException e,HttpServletRequest request) {
		StandartError err = new StandartError();
		
		err.setTimestemp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setError("Resouce not found");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandartError> ArgumentNotValid(MethodArgumentNotValidException e,HttpServletRequest request) {
		StandartError err = new StandartError();
		Map<String, String> erros = new HashMap<>();
		
		err.setTimestemp(Instant.now());
		err.setStatus(HttpStatus.BAD_REQUEST.toString());
		err.setError("Argumento(s) Inválido(s)");
		
		e.getBindingResult().getAllErrors().forEach((error) -> {
			String nome = (((FieldError) error).getField());
			String m = error.getDefaultMessage();
			erros.put(nome, m);
		});
		
		err.setMessage(erros.toString());
		err.setPath(request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		
	}
	//org.springframework.web.bind.MethodArgumentNotValidException
}
