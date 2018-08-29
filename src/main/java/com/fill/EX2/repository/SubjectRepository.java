package com.fill.EX2.repository;

import com.fill.EX2.entity.Subject;

import java.util.List;


public interface SubjectRepository {

    List<Subject> getAllSubject();

    Subject getSubjectById(Integer subject_id);

    void addSubject(Subject subject);

    void deleteSubject(Integer subject_id);

    void updateSubject(Subject subject);
}
