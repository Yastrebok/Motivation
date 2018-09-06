package com.fill.EX2.service;

import com.fill.EX2.repository.MarkRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.fill.EX2.repository.MarkRepository.Mark;

@Service
public class MarksDaoService {

    @Autowired
    MarkRepositoryImpl marksRepository;

    public List<Mark> getMarkSByUser(Integer user_id){
        return marksRepository.getMarksByUser(user_id);
    }

    public Integer insertMarks(Mark marksDto){
        return marksRepository.insertMarks(marksDto);
    }
}
