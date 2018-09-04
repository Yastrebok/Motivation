package com.fill.EX2.repository;

import com.fill.EX2.entity.User;
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
    List<User> findAll();

    /**
     *
     * @param user
     * @return
     */
    Integer save(User user);

    User getById(int id);

    void deleteById(int id);

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
}