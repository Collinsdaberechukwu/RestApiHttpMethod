package com.example.restapihttpmethods.repository;

import com.example.restapihttpmethods.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
}
