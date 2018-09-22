package com.fill.EX2.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;

public interface MarkRepository {

    List<Mark> getMarksByUser(Integer user_id);

    Integer insertMarks(Mark mark);


    @Data
    @Builder
    @NoArgsConstructor()
    @AllArgsConstructor()
    class Mark {
        private int id;
        private int subject_id;
        private int user_id;
        private int mark;
        private int rate;
        private LocalDateTime date;
    }

    RowMapper<Mark> MARK_MAPPER = (ResultSet resultSet, int row) -> {
        Mark mark = new Mark();
        mark.setId(resultSet.getInt("id"));
        mark.setSubject_id(resultSet.getInt("subject_id"));
        mark.setUser_id(resultSet.getInt("user_id"));
        mark.setRate(resultSet.getInt("rate"));
        mark.setMark(resultSet.getInt("mark"));
        mark.setDate(resultSet.getTimestamp("date").toLocalDateTime());
        return mark;
    };
}
