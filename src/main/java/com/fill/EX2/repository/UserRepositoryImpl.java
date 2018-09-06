package com.fill.EX2.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAllUsers() {
        String sql = "select user_id as id ,user_name as username,email,age from user order by user_id";
        return jdbcTemplate.query(sql, USER_MAPPER);
    }

    @Override
    public Integer saveUser(User user) {

            Integer newUser_id =  jdbcTemplate.queryForObject("SELECT MAX(user_id) as maxId FROM user", new RowMapper<Integer>() {
                        @Override
                        public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                            return (rs.getInt(1)+1);
                        }
            });

        String sql = "INSERT INTO user (user_id, user_name,email,age) values (?,?,?,?)";
        jdbcTemplate.update(sql,newUser_id, user.getUsername(),user.getEmail(), user.getAge());
        return newUser_id;
    }


    @Override
    public User getUserById(int id) {
        String sql = "SELECT user_id as id ,user_name as username,email,age FROM user WHERE user_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, USER_MAPPER, id);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public void deleteUserById(int id) {
        String sql =  "DELETE FROM user WHERE user_id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE user SET  user_name = ?, email = ?, age = ? WHERE user_id = ?";
        jdbcTemplate.update(sql, user.getUsername(), user.getEmail(),user.getAge(),user.getId());

    }

    @Override
    public List<UserResult> getUserResult(Integer user_id) {
        String query = "select sum(c.quantity * mp.multiplier) as sum, c.month from multiplier mp " +
                "join (select  m.rate, m.mark, count(*) as quantity, date_format(date,\"%Y %M\") as month " +
                "from marks_data m " +
                "where m.user_id = ? group by 1, 2) as c on mp.rate = c.rate and mp.mark = c.mark";
        return jdbcTemplate.query(query, USER_RESULT_MAPPER, user_id);
    }
}
