package com.fill.EX2.repository;

import com.fill.EX2.entity.Subject;
import com.fill.EX2.mapper.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectRepositoryImpl implements SubjectRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Subject> getAllSubject() {
        String query = "SELECT * FROM subject";
        return jdbcTemplate.query(query, new SubjectMapper());
    }

    @Override
    public Subject getSubjectById(Integer subject_id) {
        String query = "SELECT * FROM subject WHERE subject_id = ?";
        return jdbcTemplate.queryForObject(query, new SubjectMapper(),subject_id);
    }

    @Override
    public void addSubject(Subject subject) {
        String query = "INSERT INTO subject ( subject_name, rate) VALUES(?,?)";
        jdbcTemplate.update(query, subject.getSubject_name(), subject.getRate());
    }

    @Override
    public void deleteSubject(Integer subject_id) {
        String query = "DELETE FROM subject WHERE subject_id = ?";
        jdbcTemplate.update(query,subject_id);
    }

    @Override
    public void updateSubject(Subject subject) {
        String query = "UPDATE subject SET subject_name = ?, rate = ? WHERE subject_id = ?";
        jdbcTemplate.update(query, subject.getSubject_name(),subject.getRate(), subject.getSubject_id());
    }
}
