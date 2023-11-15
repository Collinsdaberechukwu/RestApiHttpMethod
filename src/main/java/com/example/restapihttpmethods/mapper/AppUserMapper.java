package com.example.restapihttpmethods.mapper;

import com.example.restapihttpmethods.dto.Request.SignUpRequest;
import com.example.restapihttpmethods.dto.Request.UpdateRequest;
import com.example.restapihttpmethods.dto.Response.AppUserResponse;
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
                .phoneNumber(request.getPhoneNumber())
                .build();
    }

    public static SignUpResponse mapSignUpResponse(AppUser response){
        return  SignUpResponse.builder()
                .email(response.getEmail())
                .phoneNumber(response.getPhoneNumber())
                .message("Registered Successfully")
                .build();
    }
    public static AppUserResponse mapAppUserResponse(AppUser getResponse){
        return AppUserResponse.builder()
                .firstName(getResponse.getFirstName())
                .lastName(getResponse.getLastName())
                .email(getResponse.getEmail())
                .phoneNumber(getResponse.getPhoneNumber())
                .location(getResponse.getLocation())
                .id(getResponse.getId())
                .build();
    }

    public static AppUser mapUpdateRequestToAppUser(AppUser appUser, UpdateRequest request){
        appUser.setFirstName(request.getFirstName());
        appUser.setLastName(request.getLastName());
        appUser.setLocation(request.getLocation());

        return appUser;
    }
}
