package com.fill.EX2.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.fill.EX2.repository.MarkRepository.MARK_MAPPER;
import static com.fill.EX2.repository.MarkRepository.Mark;

@Repository
public class MarkRepositoryImpl {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Mark> getMarksByUser(Integer user_id){
        String query = "SELECT * from marks_data WHERE user_id = ?";
        return jdbcTemplate.query(query, MARK_MAPPER, user_id);
    }

    public Integer insertMarks(Mark marks){
        String query = "INSERT INTO marks_data ( subject_id, rate, mark, user_id, date) VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(query, marks.getSubject_id(), marks.getRate(),
                marks.getMark(), marks.getUser_id(),marks.getDate());
    }

}

