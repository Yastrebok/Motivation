package com.fill.EX2.repository;

import com.fill.EX2.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@SpringBootConfiguration
public class UserRepositoryImplTest {
    private static final Integer age = 31;
    @Autowired
    public UserRepository userRepository;

    @Test
    public void usersCRUD() {
        User user = User.builder()
                .username("user")
                .build();
        // just create new user
        Integer userId = userRepository.save(user);

        // get user by id
        User byId = userRepository.getById(userId);
        assertNotNull("", byId);

        // get  all users
        List<User> all = userRepository.findAll();
        assertNull(all);


        user.setAge(age);
        userRepository.update(user);
        byId = userRepository.getById(userId);
        assertNotNull("", byId);
        assertEquals("", age, user.getAge());


        userRepository.deleteById(userId);

        userRepository.getById();
    }

    @Test
    public void findAll() {
        List<User> all = userRepository.findAll();
        assertEquals("Just added users should be in result", all.size());
    }
}