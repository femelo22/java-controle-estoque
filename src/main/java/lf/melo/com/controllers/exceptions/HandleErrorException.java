package lf.melo.com.controllers.exceptions;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lf.melo.com.errors.NotFoundError;

@ControllerAdvice
public class HandleErrorException {
	
	@ExceptionHandler(NotFoundError.class)
	public ResponseEntity<StandardError> objectNotFoundException(NotFoundError ex, HttpServletRequest request) {
		
		StandardError error = new StandardError();
		error.setError("Not Found Exception");
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setDate(LocalDateTime.now());
		error.setPath(request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
