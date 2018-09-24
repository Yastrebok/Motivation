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
public class SubjectRepositoryImpl implements SubjectRepository {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;

    @Autowired
    public SubjectRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcInsert = new SimpleJdbcInsert(jdbcTemplate.getDataSource()).withTableName("subject").usingGeneratedKeyColumns("subject_id");
    }

    @Override
    public List<Subject> getAllSubject() {
        String query = "SELECT subject_id, subject_name, rate FROM subject WHERE subject_name IS NOT NULL";
        return jdbcTemplate.query(query, SUBJECT_MAPPER);
    }

    @Override
    public Subject getSubjectById(Integer subject_id) {
        String query = "SELECT * FROM subject WHERE subject_id = ?";
        try {
            return jdbcTemplate.queryForObject(query, SUBJECT_MAPPER, subject_id);
        } catch (DataAccessException e) {
            return null;
        }
    }

    /**
     * You can use if entity property same columns' name in DB
     * SqlParameterSource parameters = new BeanPropertySqlParameterSource(subject);
     *
     * @param subject
     * @return subject_id
     */
    @Override
    public Integer addSubject(Subject subject) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("subject_name", subject.getSubjectName())
                .addValue("rate", subject.getRate());
        return jdbcInsert.executeAndReturnKey(parameters).intValue();
    }

    @Override
    public void deleteSubject(Integer subject_id) {
        String query = "DELETE FROM subject WHERE subject_id = ?";
        jdbcTemplate.update(query, subject_id);
    }

    @Override
    public void updateSubject(Subject subject) {
        String query = "UPDATE subject SET subject_name = ?, rate = ? WHERE subject_id = ?";
        jdbcTemplate.update(query, subject.getSubjectName(), subject.getRate(), subject.getId());
    }
}
