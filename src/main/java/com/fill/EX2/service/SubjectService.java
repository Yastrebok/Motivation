package com.fill.EX2.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public interface SubjectService {

    List<SubjectDto> getAllSubject();

    SubjectDto getSubjectById(Integer subjectId);

    void addSubject(SubjectDto subjectDto);

    void deleteSubject(Integer subjectId);

    void updateSubject(SubjectDto subjectDto);

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class SubjectDto {
        private int subjectId;
        private String subjectName;
        private int rate;
    }
}
