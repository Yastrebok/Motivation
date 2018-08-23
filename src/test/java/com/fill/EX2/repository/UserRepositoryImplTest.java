package com.fill.EX2.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.Assert.assertEquals;

@SpringBootConfiguration
public class UserRepositoryImplTest {

    @Autowired
    public JdbcTemplate jdbcTemplate;
    
    @Test
    public void findAll() {
        assertEquals("user1",jdbcTemplate.update("select user_name from developers.user where user_id = 1"));
    }

    @Test
    public void save() {
    }

    @Test
    public void getById() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void update() {
    }
}