package com.todoapp.ModelMapper;

import com.todoapp.Dto.UserDto;
import com.todoapp.Entities.UserDtls;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static UserDto mapToUserDto(UserDtls user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId()); userDto.setEmail(user.getEmail());
        return userDto;
    }

    public static UserDtls mapToUser(UserDto userDto){
        UserDtls user = new UserDtls();
        user.setId(userDto.getId()); user.setEmail(userDto.getEmail());
        return user;
    }


}
