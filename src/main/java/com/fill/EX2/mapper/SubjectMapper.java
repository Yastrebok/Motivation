package com.fill.EX2.mapper;

import com.fill.EX2.entity.Subject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectMapper implements RowMapper<Subject> {

    @Override
    public Subject mapRow(ResultSet resultSet, int i) throws SQLException {
        Subject subject = new Subject();
        subject.setSubject_id(resultSet.getInt("subject_id"));
        subject.setSubject_name(resultSet.getString("subject_name"));
        subject.setRate(resultSet.getInt("rate"));
        return subject;
    }
}

