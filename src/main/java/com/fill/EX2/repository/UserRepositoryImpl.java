package com.fill.EX2.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcInsert = new SimpleJdbcInsert(jdbcTemplate.getDataSource()).withTableName("user").usingGeneratedKeyColumns("user_id");
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "select user_id, user_name, email, age from user order by user_id";
        return jdbcTemplate.query(sql, USER_MAPPER);
    }

    @Override
    public Integer saveUser(User user) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("user_name",user.getUsername())
                .addValue("email", user.getEmail())
                .addValue("age", user.getAge());
        return jdbcInsert.executeAndReturnKey(parameters).intValue();
    }


    @Override
    public User getUserById(int id) {
        String sql = "SELECT user_id, user_name, email, age FROM user WHERE user_id = ?";
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

    /**
     * This method provide the result of user by month
     * @param user_id
     * @return sum which user earns in the month
     */
    @Override
    public List<UserResult> getUserResult(Integer user_id) {
        String query = "select sum(c.quantity * mp.multiplier) as sum, c.month from multiplier mp " +
                "join (select  m.rate, m.mark, count(*) as quantity, date_format(date,\"%Y %M\") as month " +
                "from marks_data m " +
                "where m.user_id = ? group by 1, 2) as c on mp.rate = c.rate and mp.mark = c.mark";
        return jdbcTemplate.query(query, USER_RESULT_MAPPER, user_id);
    }
}
