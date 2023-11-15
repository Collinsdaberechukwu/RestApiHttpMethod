package com.example.restapihttpmethods.service;

import com.example.restapihttpmethods.dto.Request.SignUpRequest;
import com.example.restapihttpmethods.dto.Response.SignUpResponse;
import com.example.restapihttpmethods.model.AppUser;
import org.springframework.http.ResponseEntity;

public interface AppUserService {
//    AppUser createUser(SignUpRequest request);

    ResponseEntity<SignUpResponse> createUser(SignUpRequest request);

    ResponseEntity<SignUpResponse> createAllUser(SignUpRequest request);
}
