package com.fill.EX2.repository;

import com.fill.EX2.entity.User;
import com.fill.EX2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String MAPPER_NAMESPACE = "";

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        String sql = "select user_id as id ,user_name as username,email,age from user order by user_id";
        return jdbcTemplate.query(sql,new UserMapper());
    }

    @Override
    public Integer save(User user) {
        String sql = "INSERT INTO user (user_name,email,age) values (?,?,?)";
        return jdbcTemplate.update(sql, user.getUsername(),user.getEmail(), user.getAge());
    }

    @Override
    public User getById(int id) {
        String sql = "SELECT user_id as id ,user_name as username,email,age FROM user WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(),id);
    }

    @Override
    public void deleteById(int id) {
        String sql =  "DELETE FROM user WHERE user_id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE user SET  user_name = ?, email = ?, age = ? WHERE user_id = ?";
        jdbcTemplate.update(sql, user.getUsername(), user.getEmail(),user.getAge(),user.getId());

    }

    @Override
    public List<UserResult> getUserResult(Integer user_id) {
        String query = "select  sum(c.quantity * mp.multiplier) as sum, c.month from multiplier mp " +
                "join (select  m.rate, m.mark, count(*) as quantity, date_format(date,\"%Y %M\") as month " +
                "from marks_data m " +
                "where m.user_id = ? group by 1, 2) as c on mp.rate = c.rate and mp.mark = c.mark";
        return jdbcTemplate.query(query, USER_RESULT_MAPPER, user_id);
    }
}
