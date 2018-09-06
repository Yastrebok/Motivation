package com.fill.EX2.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.fill.EX2.repository.MarkRepository.Mark;
import static org.junit.Assert.assertEquals;

@Slf4j
public class MarkRepositoryImplTest {

    @Autowired
    private MarkRepositoryImpl markRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void getMarksByUser() {

        Mark newDto = new Mark();
        newDto.setId(6);
        newDto.setUser_id(7);
        newDto.setSubject_id(7);
        newDto.setRate(1);
        newDto.setMark(8);
        newDto.setDate("");

        assertEquals(newDto, markRepository.getMarksByUser(7));
    }

    @Test
    public void insertMarks() {
    }
}