package com.aone.config;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.model.impl.ErrorResponse;

/**
 * The Class GlobalExceptionHandler.
 * 
 * @author bharat tulsiyani
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/**
	 * Handle SQL exception.
	 *
	 * @param request the request
	 * @param ex the ex
	 * @return the response entity
	 */
	@ExceptionHandler(SQLException.class)
	public @ResponseBody ResponseEntity<ErrorResponse> handleSQLException(HttpServletRequest request, Exception ex){
		logger.error("SQLException Occured:: URL="+request.getRequestURL(), ex);
		ErrorResponse errorResponse = new ErrorResponse(ResultCodeConstant.INTERNAL_ERROR, "requestToken", "SQLException Occured:: URL="+request.getRequestURL());
		return new ResponseEntity<>(errorResponse, HttpStatus.OK);
	}
	
	/**
	 * Handle IO exception.
	 *
	 * @return the response entity
	 */
	@ExceptionHandler(IOException.class)
	public @ResponseBody ResponseEntity<ErrorResponse> handleIOException(Exception ex){
		logger.error("IOException handler executed", ex);
		ErrorResponse errorResponse = new ErrorResponse(ResultCodeConstant.INTERNAL_ERROR, "requestToken", "IOException handler executed");
		return new ResponseEntity<>(errorResponse, HttpStatus.OK);
	}
	
	/**
	 * Handle exception.
	 *
	 * @return the response entity
	 */
	@ExceptionHandler(Exception.class)
	public @ResponseBody ResponseEntity<ErrorResponse> handleException(Exception e){
		logger.error("Exception occurred", e);
		ErrorResponse errorResponse = new ErrorResponse(ResultCodeConstant.INTERNAL_ERROR, "requestToken", "Exception occurred");
		return new ResponseEntity<>(errorResponse, HttpStatus.OK);
	}
}
