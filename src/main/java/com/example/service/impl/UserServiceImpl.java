package com.example.service.impl;

import com.example.dto.UserRegisterRequestDto;
import com.example.dto.UserRegisterResponseDto;
import com.example.exception.RegistrationException;
import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserRegisterResponseDto register(UserRegisterRequestDto request)
            throws RegistrationException  {
        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new RegistrationException("Unable to complete registration");
        }

        User user = new User();
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public List<UserRegisterResponseDto> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }
}
