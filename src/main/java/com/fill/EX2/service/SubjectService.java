package com.fill.EX2.service;

import com.fill.EX2.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.fill.EX2.repository.SubjectRepository.Subject;

@Service
public class SubjectService {

    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<SubjectDto> getAllSubject(){
        return subjectRepository.getAllSubject().stream()
                .map(this::convertToSubjectDto)
                .collect(Collectors.toList());
    }

    public SubjectDto getSubjectById(Integer subject_id){
        return convertToSubjectDto(subjectRepository.getSubjectById(subject_id));
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

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class SubjectDto {
        private int subjectId;
        private String subjectName;
        private int rate;
    }

    private SubjectDto convertToSubjectDto(Subject subject) {
        return SubjectDto.builder()
                .subjectId(subject.getId())
                .subjectName(subject.getSubjectName())
                .rate(subject.getRate())
                .build();
    }
}
