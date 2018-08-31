package com.fill.EX2.repository;

import com.fill.EX2.entity.MarksDto;
import com.fill.EX2.mapper.MarksDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MarksRepositoryImpl {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<MarksDto> getMarksByUser(Integer user_id){
        String query = "SELECT * from marks_data WHERE user_id = ?";
        return jdbcTemplate.query(query, new MarksDtoMapper(), user_id);
    }


    public void insertMarks(MarksDto marksDto){
        String query = "INSERT INTO marks_data ( subject_id, rate, mark, user_id, date) VALUES(?,?,?,?,?)";
        jdbcTemplate.update(query, marksDto.getSubject_id(), marksDto.getRate(),
                marksDto.getMark(), marksDto.getUser_id(),marksDto.getDate());
    }
}

