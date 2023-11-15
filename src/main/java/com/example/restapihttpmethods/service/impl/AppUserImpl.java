package com.example.restapihttpmethods.service.impl;

import com.example.restapihttpmethods.repository.AppUserRepository;
import com.example.restapihttpmethods.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AppUserImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
}
