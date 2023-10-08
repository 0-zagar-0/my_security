package com.example.controller;

import com.example.dto.UserRegisterRequestDto;
import com.example.dto.UserRegisterResponseDto;
import com.example.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public UserRegisterResponseDto register(@RequestBody @Valid UserRegisterRequestDto request) {
        return userService.register(request);
    }

    @GetMapping
    public List<UserRegisterResponseDto> findAll() {
        return userService.findAll();
    }
}
