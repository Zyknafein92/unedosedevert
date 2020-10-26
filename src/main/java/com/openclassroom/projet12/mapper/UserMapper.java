package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.UserDTO;
import com.openclassroom.projet12.model.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    User userDTOtoUser(UserDTO userDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    User updateUserFromUserDTO(UserDTO userDTO, @MappingTarget User user);
}
