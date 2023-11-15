package com.example.restapihttpmethods.service.impl;

import com.example.restapihttpmethods.dto.Request.SignUpRequest;
import com.example.restapihttpmethods.dto.Request.UpdateRequest;
import com.example.restapihttpmethods.dto.Response.AppUserResponse;
import com.example.restapihttpmethods.dto.Response.SignUpResponse;
import com.example.restapihttpmethods.exception.UserAlreadyExistException;
import com.example.restapihttpmethods.exception.UserNotFoundException;
import com.example.restapihttpmethods.mapper.AppUserMapper;
import com.example.restapihttpmethods.model.AppUser;
import com.example.restapihttpmethods.repository.AppUserRepository;
import com.example.restapihttpmethods.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AppUserImpl implements AppUserService {
    private final AppUserRepository appUserRepository;

    @Override
    public ResponseEntity<SignUpResponse> createUser(SignUpRequest request){
        if (appUserRepository.existsByEmailOrPhoneNumber(request.getEmail(),request.getPhoneNumber())){
            throw new UserAlreadyExistException("Details provided as already been signup");
        }
        AppUser appUser= appUserRepository.save(AppUserMapper.mapSignUpRequestToAppUser(request));
        return new ResponseEntity<>(AppUserMapper.mapSignUpResponse(appUser),HttpStatus.CREATED);

    }
    @Override
   public ResponseEntity<AppUserResponse> getUserById(Long id){
        AppUser appUser = appUserRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("User not available"));
        return new ResponseEntity<>(AppUserMapper.mapAppUserResponse(appUser),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteUserById(Long id){
         appUserRepository.deleteById(id);
         return new ResponseEntity<>("User deleted successfully",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AppUserResponse> updateUser(UpdateRequest request, Long id){
        AppUser appUser = appUserRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("User not found"));

        appUser = appUserRepository.save(AppUserMapper.mapUpdateRequestToAppUser(appUser,request));
        return new ResponseEntity<>(AppUserMapper.mapAppUserResponse(appUser),HttpStatus.OK);

    }
    @Override
    public ResponseEntity<List<AppUserResponse>>  getAllUser(){
       List<AppUserResponse> appUsers= appUserRepository.findAll()
               .stream().map(AppUserMapper::mapAppUserResponse)
               .collect(Collectors.toList());
        return new ResponseEntity<>(appUsers, HttpStatus.OK);
    }

}
