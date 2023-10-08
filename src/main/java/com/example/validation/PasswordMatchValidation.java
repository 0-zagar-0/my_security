package com.example.validation;

import com.example.dto.UserRegisterRequestDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchValidation implements
        ConstraintValidator<PasswordMatch, UserRegisterRequestDto> {
    @Override
    public boolean isValid(UserRegisterRequestDto request, ConstraintValidatorContext context) {
        return request.password() != null && request.repeatPassword() != null
                && request.password().equals(request.repeatPassword());
    }
}
