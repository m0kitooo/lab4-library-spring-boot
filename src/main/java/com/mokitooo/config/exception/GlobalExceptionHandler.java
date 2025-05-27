package com.mokitooo.config.exception;

import com.mokitooo.dto.AppResponseDto;
import com.mokitooo.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<AppResponseDto<Void>> handleResourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>(AppResponseDto.error(e), HttpStatus.NOT_FOUND);
    }
}
