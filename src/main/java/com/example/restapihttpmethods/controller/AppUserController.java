package com.example.restapihttpmethods.controller;

import com.example.restapihttpmethods.dto.Request.SignUpRequest;
import com.example.restapihttpmethods.model.AppUser;
import com.example.restapihttpmethods.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class AppUserController {

    private final AppUserService appUserService;

    @PostMapping("/create-user")
    @ResponseStatus(HttpStatus.CREATED)
    public AppUser createdUser(@RequestBody SignUpRequest request){
        return appUserService.createUser(request);
    }

}
