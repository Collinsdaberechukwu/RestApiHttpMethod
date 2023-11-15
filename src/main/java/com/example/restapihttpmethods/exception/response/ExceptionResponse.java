package com.example.restapihttpmethods.exception.response;

import lombok.*;

import java.time.LocalDateTime;

//                   this class is like a dto
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionResponse {
    private int status;
    private String message;
    private String error;
    private String path;
    private LocalDateTime timestamp;
}
