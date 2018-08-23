package com.fill.EX2.service;

import com.fill.EX2.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void save(User user);

    User getById(int id);

    void deleteById(int id);

    void update(User user);
}
