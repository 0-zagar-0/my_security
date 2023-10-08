package com.example.service;

import com.example.dto.UserRegisterRequestDto;
import com.example.dto.UserRegisterResponseDto;
import java.util.List;

public interface UserService {
    UserRegisterResponseDto register(UserRegisterRequestDto request);

    List<UserRegisterResponseDto> findAll();
}
