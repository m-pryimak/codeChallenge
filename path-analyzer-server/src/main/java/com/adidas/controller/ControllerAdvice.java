package com.adidas.controller;

import com.adidas.exceptions.PathAnalyzerRestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ControllerAdvice {
    
    private static final Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

	@ExceptionHandler(value = RuntimeException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public PathAnalyzerRestException handleRuntime(RuntimeException ex) {
	    logger.error("RuntimeException handled:", ex);
		return new PathAnalyzerRestException(new Date().getTime(), "An Error occurred while handling your request! Please try again later :)");
	}

	@ExceptionHandler({ MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public PathAnalyzerRestException handleArgumentInvalid(Exception ex) {
	    logger.error("InvalidArgument handled:", ex);
		return new PathAnalyzerRestException(new Date().getTime(), "Posted data is invalid! Please try again! :)");
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public PathAnalyzerRestException handleException(Exception ex) {
	    logger.error("Exception handled:", ex);
		return new PathAnalyzerRestException(new Date().getTime(), "An Error occurred while handling your request! Please try again later :)");
	}
}
