package com.example.service;

import com.example.dto.UserRegisterRequestDto;
import com.example.dto.UserRegisterResponseDto;
import com.example.exception.RegistrationException;
import java.util.List;

public interface UserService {
    UserRegisterResponseDto register(UserRegisterRequestDto request)
            throws RegistrationException;

    List<UserRegisterResponseDto> findAll();
}
