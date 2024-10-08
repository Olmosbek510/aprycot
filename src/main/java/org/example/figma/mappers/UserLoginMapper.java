package org.example.figma.mappers;

import org.example.figma.dto.LoginDto;
import org.example.figma.entity.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserLoginMapper {
    User toEntity(LoginDto loginDto);

    LoginDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(LoginDto loginDto, @MappingTarget User user);
}