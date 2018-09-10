package com.fill.EX2.service;

import com.fill.EX2.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.fill.EX2.repository.SubjectRepository.Subject;

@Service
public class SubjectServiceImpl implements SubjectService{

    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
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

    public void addSubject(SubjectDto subject){
        subjectRepository.addSubject(convertToSubject(subject) );
    }

    public void deleteSubject(Integer subject_id) {
        subjectRepository.deleteSubject(subject_id);
    }

    public void updateSubject(SubjectDto subject) {
        subjectRepository.updateSubject(convertToSubject(subject));
    }



    private SubjectDto convertToSubjectDto(Subject subject) {
        return SubjectDto.builder()
                .subjectId(subject.getId())
                .subjectName(subject.getSubjectName())
                .rate(subject.getRate())
                .build();
    }

    private Subject convertToSubject(SubjectDto subjectDto) {
        return Subject.builder()
                .id(subjectDto.getSubjectId())
                .subjectName(subjectDto.getSubjectName())
                .rate(subjectDto.getRate())
                .build();
    }
}
