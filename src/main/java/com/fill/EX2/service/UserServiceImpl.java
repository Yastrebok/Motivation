package com.fill.EX2.service;

import com.fill.EX2.repository.UserRepository;
import com.fill.EX2.repository.UserRepository.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    public UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(UserDto user) {
        User user1 = convertUser(user);
        userRepository.save(user1);
    }

    @Override
    public UserDto getById(int id) {
        repo.getIds();
        getUserBYIDs();


        User byId = userRepository.getById(id);
        UserDto userDto = convertUser(byId);
        return userDto;
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(UserRepository.User user) {
        userRepository.updateUser(user);
    }

    @Override
    public List<UserRepository.UserResult> getUserResult(Integer user_id) {
        return userRepository.getUserResult(user_id);
    }

    private UserRepository.User convertUser(UserDto userDto) {

    }

    private UserDto convertUser(User user) {

    }
}
