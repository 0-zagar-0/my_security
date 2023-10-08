package com.example.mapper;

import com.example.config.MapperConfig;
import com.example.dto.UserRegisterRequestDto;
import com.example.dto.UserRegisterResponseDto;
import com.example.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserRegisterResponseDto toDto(User user);

    User toModel(UserRegisterRequestDto request);
}
