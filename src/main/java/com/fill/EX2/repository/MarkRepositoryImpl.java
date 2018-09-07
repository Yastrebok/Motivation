package com.fill.EX2.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MarkRepositoryImpl implements MarkRepository{

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;

    @Autowired
    public MarkRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcInsert = new SimpleJdbcInsert(jdbcTemplate.getDataSource()).withTableName("marks_data").usingGeneratedKeyColumns("id");
    }

    public List<Mark> getMarksByUser(Integer user_id){
        String query = "SELECT * from marks_data WHERE user_id = ?";
        return jdbcTemplate.query(query, MARK_MAPPER, user_id);
    }

    public Integer insertMarks(Mark marks){
        SqlParameterSource parameters = new BeanPropertySqlParameterSource(marks);
        return jdbcInsert.executeAndReturnKey(parameters).intValue();
//        String query = "INSERT INTO marks_data ( subject_id, rate, mark, user_id, date) VALUES(?,?,?,?,?)";
//        return jdbcTemplate.update(query, marks.getSubject_id(), marks.getRate(),
//                marks.getMark(), marks.getUser_id(),marks.getDate());
    }

}

