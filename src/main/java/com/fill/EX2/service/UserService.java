package com.fill.EX2.service;

import com.fill.EX2.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.fill.EX2.repository.UserRepository.UserResult;

interface UserService {

    List<UserDto> findAll();

    void save(User user);

    User getById(int id);

    void deleteById(int id);

    void update(UserDto user);

    List<UserResult> getUserResult(Integer user_id);

    @Data
    @Builder
    @NoArgsConstructor(access = AccessLevel.PUBLIC)
    @AllArgsConstructor(access = AccessLevel.PUBLIC)
    class UserDto {
        private int id;
        private String username;
        private String email;
        private int age;
    }
}
