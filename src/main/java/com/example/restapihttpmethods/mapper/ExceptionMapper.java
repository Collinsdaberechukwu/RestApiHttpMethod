package com.example.restapihttpmethods.mapper;

import com.example.restapihttpmethods.exception.response.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ExceptionMapper {
    public static ExceptionResponse mapExceptionResponse(Exception e, HttpServletRequest request, HttpStatus status){
        return ExceptionResponse.builder()
                .error(status.name())
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .path(request.getRequestURI())
                .status(status.value())
                .build();
    }
}
