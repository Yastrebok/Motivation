package com.fill.EX2.repository;

import com.fill.EX2.Application;
import com.fill.EX2.WebAppInitializer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static com.fill.EX2.repository.UserRepository.User;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@SpringBootConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes ={ Application.class, WebAppInitializer.class})
public class UserRepositoryImplTest {
    private static final Integer age = 31;

    @Autowired
    public UserRepository userRepository;

    @Test
    public void usersCRUD() {
        User user = User.builder()
                .username("userTest")
                .email("test")
                .build();
        // just create new user
        Integer idSavedUser = userRepository.saveUser(user);
        System.out.println("new user_id = " + idSavedUser);
        // get user by id
        User newUserbyId = userRepository.getUserById(idSavedUser);
        assertNotNull("Just added users should be in result", newUserbyId);

        // get  all users
        List<User> all = userRepository.getAllUsers();
        assertNotNull(all);

        //update User
        user.setAge(age);
        userRepository.updateUser(user);
        newUserbyId = userRepository.getUserById(idSavedUser);
        assertNotNull("Just updated users should be in result", newUserbyId);
        assertEquals("Updated parameter should be the same", (int) age, user.getAge());

        //deletion user
        userRepository.deleteUserById(idSavedUser);
        assertNull("Just null should be", userRepository.getUserById(idSavedUser));
    }
}

