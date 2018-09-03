package com.fill.EX2.service;

import com.fill.EX2.entity.User;

import java.util.List;

import static com.fill.EX2.repository.UserRepository.UserResult;

public interface UserService {

    List<User> findAll();

    void save(User user);

    User getById(int id);

    void deleteById(int id);

    void update(User user);

    List<UserResult> getUserResult(Integer user_id);
}
