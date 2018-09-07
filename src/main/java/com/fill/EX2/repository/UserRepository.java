package com.fill.EX2.repository;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;

public interface UserRepository {

    /**
     *
     * @return
     */
    List<User> getAllUsers();

    /**
     *
     * @param user
     * @return
     */
    Integer saveUser(User user);

    User getUserById(int id);

    void deleteUserById(int id);

    void updateUser(User user);

    List<UserResult> getUserResult(Integer user_id);

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class UserResult {
        private String month;
        private Double sum;
    }

    RowMapper<UserResult> USER_RESULT_MAPPER = (ResultSet resultSet, int row) -> {
        UserResult sum = new UserResult();
        sum.setMonth(resultSet.getString("month"));
        sum.setSum(resultSet.getDouble("sum"));
        return sum;
    };

    @Data
    @Builder
    @NoArgsConstructor(access = AccessLevel.PUBLIC)
    @AllArgsConstructor(access = AccessLevel.PUBLIC)
    class User {
        private int id;
        private String username;
        private String email;
        private int age;
    }

    RowMapper<User> USER_MAPPER = (ResultSet resultSet, int row) -> {
        User user = new User();
        user.setId(resultSet.getInt("user_id"));
        user.setUsername(resultSet.getString("user_name"));
        user.setEmail(resultSet.getString("email"));
        user.setAge(resultSet.getInt("age"));
        return user;
    };
}