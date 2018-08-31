package com.fill.EX2.service;

import com.fill.EX2.entity.MarksDto;
import com.fill.EX2.repository.MarksRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarksDaoService {

    @Autowired
    MarksRepositoryImpl marksRepository;

    public List<MarksDto> getMarkSByUser(Integer user_id){
        return marksRepository.getMarksByUser(user_id);
    }

    public void insertMarks(MarksDto marksDto){
        marksRepository.insertMarks(marksDto);
    }
}
