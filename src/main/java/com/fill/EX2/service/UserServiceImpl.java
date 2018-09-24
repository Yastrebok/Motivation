package com.fill.EX2.service;

import com.fill.EX2.repository.UserRepository;
import com.fill.EX2.repository.UserRepository.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAllUserDto() {
        return userRepository.getAllUsers().stream()
                .filter(user -> user.getUsername() != null)
                .map(this::convertToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveUserDto(UserDto userDto) {
        userRepository.saveUser(convertToUser(userDto));
    }

    @Override
    public UserDto getUserDtoById(int id) {
        User byId = userRepository.getUserById(id);
        return convertToUserDto(byId);
    }

    @Override
    public void deleteUserDtoById(int id) {
        //???
        userRepository.deleteUserById(id);
    }

    @Override
    public void updateUserDto(UserDto userDto) {
        userRepository.updateUser(convertToUser(userDto));
    }

    @Override
    public UserDto getUserResult(Integer user_id) {
        UserDto userDto = getUserDtoById(user_id);
        userDto.setResultList(userRepository.getUserResult(user_id));
        return  userDto;
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
