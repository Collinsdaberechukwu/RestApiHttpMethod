package com.example.restapihttpmethods.controller;

import com.example.restapihttpmethods.dto.Request.SignUpRequest;
import com.example.restapihttpmethods.dto.Response.AppUserResponse;
import com.example.restapihttpmethods.dto.Response.SignUpResponse;
import com.example.restapihttpmethods.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class AppUserController {

    private final AppUserService appUserService;

    @PostMapping("/create-user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SignUpResponse> createdUser(@RequestBody SignUpRequest request){
        return appUserService.createUser(request);
    }

    @GetMapping("get-user/{id}")
    public ResponseEntity<AppUserResponse> getUserById(@PathVariable Long id){
        return appUserService.getUserById(id);
    }
    @GetMapping("get-all-users")
    public ResponseEntity<List<AppUserResponse>> getAllUsers(){
        return appUserService.getAllUser();
    }
}
