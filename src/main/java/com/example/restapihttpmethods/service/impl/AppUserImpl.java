package com.example.restapihttpmethods.service.impl;

import com.example.restapihttpmethods.dto.Request.SignUpRequest;
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

//    @Override
//    public ResponseEntity<SignUpResponse> createAllUser(SignUpRequest request){
//        if (appUserRepository.existsByEmailOrPhoneNumber(request.getEmail(),request.getPhoneNumber())){
//            throw new RuntimeException("Details already been used");
//        }
//        AppUser appUser = appUserRepository.save(AppUserMapper.mapSignUpRequestToAppUser(request));
//
//        return new ResponseEntity<>(AppUserMapper.mapSignUpResponse(appUser),HttpStatus.CREATED);
//    }

    @Override
   public ResponseEntity<AppUserResponse> getUserById(Long id){
        AppUser appUser = appUserRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("User not available"));
        return new ResponseEntity<>(AppUserMapper.mapAppUserResponse(appUser),HttpStatus.OK);
    }

}
