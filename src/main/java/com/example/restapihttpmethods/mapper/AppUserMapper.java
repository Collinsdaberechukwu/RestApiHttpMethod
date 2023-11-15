package com.example.restapihttpmethods.mapper;

import com.example.restapihttpmethods.dto.Request.SignUpRequest;
import com.example.restapihttpmethods.dto.Response.SignUpResponse;
import com.example.restapihttpmethods.model.AppUser;

public class AppUserMapper {
    public static AppUser mapSignUpRequestToAppUser(SignUpRequest request){
        return AppUser.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .location(request.getLocation())
                .password(request.getPassword())
                .build();
    }

    public static SignUpResponse mapSignUpResponse(AppUser response){
        return  SignUpResponse.builder()
                .email(response.getEmail())
                .password(response.getPassword())
                .message("Registered Successfully")
                .build();
    }
}
