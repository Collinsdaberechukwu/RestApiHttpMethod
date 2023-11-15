package com.example.restapihttpmethods.service;

import com.example.restapihttpmethods.dto.Request.SignUpRequest;
import com.example.restapihttpmethods.dto.Request.UpdateRequest;
import com.example.restapihttpmethods.dto.Response.AppUserResponse;
import com.example.restapihttpmethods.dto.Response.SignUpResponse;
import com.example.restapihttpmethods.model.AppUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AppUserService {
//    AppUser createUser(SignUpRequest request);

    ResponseEntity<SignUpResponse> createUser(SignUpRequest request);

//    ResponseEntity<SignUpResponse> createAllUser(SignUpRequest request);

    ResponseEntity<AppUserResponse> getUserById(Long id);


    ResponseEntity<String> deleteUserById(Long id);

    ResponseEntity<AppUserResponse> updateUser(UpdateRequest request, Long id);

    ResponseEntity<List<AppUserResponse>>  getAllUser();
}
