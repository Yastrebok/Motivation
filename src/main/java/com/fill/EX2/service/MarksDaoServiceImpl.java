package com.fill.EX2.service;

import com.fill.EX2.repository.MarkRepository;
import com.fill.EX2.repository.MarkRepositoryImpl;
import com.fill.EX2.repository.SubjectRepository;
import com.fill.EX2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.fill.EX2.repository.MarkRepository.Mark;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

@Service
public class MarksDaoServiceImpl implements MarkDaoService {

    private MarkRepository marksRepository;
    private SubjectRepository subjectRepository;
    private UserRepository userRepository;

    @Autowired
    public MarksDaoServiceImpl(MarkRepositoryImpl marksRepository, SubjectRepository subjectRepository,
                               UserRepository userRepository) {
        this.marksRepository = marksRepository;
        this.subjectRepository = subjectRepository;
        this.userRepository = userRepository;
    }

    public List<MarkDto> getMarkSByUser(Integer user_id) {
        return marksRepository.getMarksByUser(user_id).stream()
                .map(this::convertToMarkDto)
                .collect(Collectors.toList());
    }

    public Integer insertMarks(MarkDto marksDto) {
        // GET rate for subject
        marksDto.setRate(subjectRepository.getSubjectById(marksDto.getSubjectId()).getRate());
        return marksRepository.insertMarks(convertToMark(marksDto));
    }

    private Mark convertToMark(MarkDto marksDto) {
        return Mark.builder()
                .id(marksDto.getId())
                .user_id(marksDto.getUserId())
                .subject_id(marksDto.getSubjectId())
                .mark(marksDto.getMark())
                .date(convertToDate(marksDto.getMonth()))
                .rate(marksDto.getRate())
                .build();
    }

    private LocalDateTime convertToDate(String month) {
        return LocalDate.parse(month).atStartOfDay();
    }

    private MarkDto convertToMarkDto(Mark mark) {
        return MarkDto.builder()
                .id(mark.getId())
                .userId(mark.getUser_id())
                .userName(userRepository.getUserById(mark.getUser_id()).getUsername())
                .subjectId(mark.getSubject_id())
                .subjectName(subjectRepository.getSubjectById(mark.getSubject_id()).getSubjectName())
                .mark(mark.getMark())
                .month(mark.getDate() == null ? "" : mark.getDate().format(ISO_LOCAL_DATE))
                .rate(mark.getRate())
                .build();
    }

    public List<Integer> getTemplateMarks() {
        return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    }
}
