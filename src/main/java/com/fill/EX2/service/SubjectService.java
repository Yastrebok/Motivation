package com.fill.EX2.service;

import com.fill.EX2.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.fill.EX2.repository.SubjectRepository.*;

@Service
public class SubjectService {

    @Autowired
    public SubjectRepository subjectRepository;

    public List<Subject> getAllSubject(){
        return subjectRepository.getAllSubject();
    }

    public Subject getSubjectById(Integer subject_id){
        return subjectRepository.getSubjectById(subject_id);
    }

    public void addSubject(Subject subject){
        subjectRepository.addSubject(subject);
    }

    public void deleteSubject(Integer subject_id) {
        subjectRepository.deleteSubject(subject_id);
    }

    public void updateSubject(Subject subject) {
        subjectRepository.updateSubject(subject);
    }
}
