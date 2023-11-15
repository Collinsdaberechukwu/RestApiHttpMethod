package com.example.restapihttpmethods.exception.handler;

import com.example.restapihttpmethods.exception.UserAlreadyExistException;
import com.example.restapihttpmethods.exception.UserNotFoundException;
import com.example.restapihttpmethods.exception.response.ExceptionResponse;
import com.example.restapihttpmethods.mapper.ExceptionMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//                  this class handlers the customize exception

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> userAlreadyExistException(UserAlreadyExistException e, HttpServletRequest request){
        ExceptionResponse exceptionResponse = ExceptionMapper.mapExceptionResponse(e,request, HttpStatus.CONFLICT);

        return new ResponseEntity<>(exceptionResponse,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponse> userNotFoundException(UserNotFoundException e, HttpServletRequest request){
        ExceptionResponse exceptionResponse = ExceptionMapper.mapExceptionResponse(e,request,HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
    }
}
