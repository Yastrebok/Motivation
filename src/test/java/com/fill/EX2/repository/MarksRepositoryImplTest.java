package com.fill.EX2.repository;

import com.fill.EX2.entity.MarksDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@Slf4j
public class MarksRepositoryImplTest {

    @Autowired
    private MarksRepositoryImpl marksRepository;

    @Test
    public void getMarksByUser() {

        MarksDto newDto = new MarksDto();
        newDto.setId(6);
        newDto.setUser_id(7);
        newDto.setSubject_id(7);
        newDto.setRate(1);
        newDto.setMark(8);
        newDto.setDate(new Date("2018-08-30"));

        assertEquals(newDto, marksRepository.getMarksByUser(7));
    }

    @Test
    public void insertMarks() {
    }
}