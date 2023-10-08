package com.example.controller;

import com.example.dto.UserLoginRequestDto;
import com.example.dto.UserLoginResponseDto;
import com.example.dto.UserRegisterRequestDto;
import com.example.dto.UserRegisterResponseDto;
import com.example.exception.RegistrationException;
import com.example.security.AuthenticationService;
import com.example.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public UserRegisterResponseDto register(@RequestBody @Valid UserRegisterRequestDto request)
            throws RegistrationException {
        return userService.register(request);
    }

    @PostMapping("/login")
    public UserLoginResponseDto login(@RequestBody UserLoginRequestDto request) {
        return authenticationService.authenticate(request);
    }
}
