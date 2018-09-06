package com.fill.EX2.service;

import com.fill.EX2.repository.UserRepository;
import com.fill.EX2.repository.UserRepository.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.fill.EX2.repository.UserRepository.UserResult;

@Service
public class UserServiceImpl implements UserService {


    public UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.getAllUsers().stream()
                .map(this::convertToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public void save(UserDto userDto) {
        userRepository.saveUser(convertToUser(userDto));
    }

    @Override
    public UserDto getById(int id) {
        User byId = userRepository.getUserById(id);
        return convertToUserDto(byId);
    }

    @Override
    public void deleteById(int id) {
        //???
        userRepository.deleteUserById(id);
    }

    @Override
    public void update(UserDto userDto) {
        userRepository.updateUser(convertToUser(userDto));
    }

    @Override
    public List<UserResult> getUserResult(Integer user_id) {
        return userRepository.getUserResult(user_id);
    }

    private User convertToUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .age(userDto.getAge())
                .email(userDto.getEmail())
                .build();
    }

    private UserDto convertToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .age(user.getAge())
                .email(user.getEmail())
                .build();
    }


}
