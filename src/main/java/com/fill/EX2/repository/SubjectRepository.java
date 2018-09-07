package com.fill.EX2.repository;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;


public interface SubjectRepository {

    List<Subject> getAllSubject();

    Subject getSubjectById(Integer subject_id);

    Integer addSubject(Subject subject);

    void deleteSubject(Integer subject_id);

    void updateSubject(Subject subject);

    @Data
    @Builder
    @NoArgsConstructor(access = AccessLevel.PUBLIC)
    @AllArgsConstructor(access = AccessLevel.PUBLIC)
    class Subject {
        private int id;
        private String subjectName;
        private int rate;
    }

    RowMapper<Subject> SUBJECT_MAPPER = (ResultSet resultSet, int row) -> {
        Subject subject = new Subject();
        subject.setId(resultSet.getInt("subject_id"));
        subject.setSubjectName(resultSet.getString("subject_name"));
        subject.setRate(resultSet.getInt("rate"));
        return subject;
    };
}
