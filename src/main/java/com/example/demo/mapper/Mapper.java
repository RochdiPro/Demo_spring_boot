package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    public static User map(UserDto user) {
        return new User(user.getId(),user.getUserName(),user.getFirstName(),user.getLastName(),user.getPassword(), user.getRole());
    }

    public static UserDto map(User user) {
        return new UserDto(user.getId(),user.getUsername(),user.getFirstName(),user.getLastName(),null, user.getRole());
    }

    public static List<UserDto> mapUsersToDtos(List<User> users)
    {
        return users.stream()
                .map(Mapper::map)
                .collect(Collectors.toList());
    }
    public static List<User> mapDtosToUsers(List<UserDto> users)
    {
        return users.stream()
                .map(Mapper::map)
                .collect(Collectors.toList());
    }

}
