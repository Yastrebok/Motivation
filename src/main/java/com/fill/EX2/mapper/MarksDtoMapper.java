package com.fill.EX2.mapper;

import com.fill.EX2.entity.MarksDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MarksDtoMapper implements RowMapper<MarksDto> {

    @Override
    public MarksDto mapRow(ResultSet resultSet, int i) throws SQLException {
        MarksDto marksDto = new MarksDto();
        marksDto.setId(resultSet.getInt("id"));
        marksDto.setSubject_id(resultSet.getInt("subject_id"));
        marksDto.setUser_id(resultSet.getInt("user_id"));
        marksDto.setRate(resultSet.getInt("rate"));
        marksDto.setMark(resultSet.getInt("mark"));
        marksDto.setDate(resultSet.getDate("date"));
        return marksDto;
    }
}
