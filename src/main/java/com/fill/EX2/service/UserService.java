package com.fill.EX2.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.fill.EX2.repository.UserRepository.UserResult;

public interface UserService {

    List<UserDto> getAllUserDto();

    void saveUserDto(UserDto user);

    UserDto getUserDtoById(int id);

    void deleteUserDtoById(int id);

    void updateUserDto(UserDto user);

    UserDto getUserResult(Integer user_id);

    @Data
    @Builder
    @NoArgsConstructor(access = AccessLevel.PUBLIC)
    @AllArgsConstructor(access = AccessLevel.PUBLIC)
    class UserDto {
        private int id;
        private String username;
        private String email;
        private int age;
        private List<UserResult> resultList;
    }

}
