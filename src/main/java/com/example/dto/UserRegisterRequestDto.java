package com.example.dto;

import com.example.validation.PasswordMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@PasswordMatch
public record UserRegisterRequestDto(
        @NotBlank
        @Size(min = 6, max = 50)
        @Email
        String email,
        @NotBlank
        @Size(min = 6, max = 50)
        String password,
        @NotBlank
        @Size(min = 6, max = 50)
        String repeatPassword) {
}
