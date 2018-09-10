package com.fill.EX2.service;

import com.fill.EX2.repository.MarkRepositoryImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.fill.EX2.repository.MarkRepository.Mark;

@Service
public class MarksDaoService {

    @Autowired
    MarkRepositoryImpl marksRepository;

    public List<MarkDto> getMarkSByUser(Integer user_id){
        return marksRepository.getMarksByUser(user_id).stream()
                .map(this::convertToMarkDto)
                .collect(Collectors.toList());
    }


    public Integer insertMarks(MarkDto marksDto){
        return marksRepository.insertMarks(convertToMark(marksDto));
    }

    private Mark convertToMark(MarkDto marksDto) {
        return Mark.builder()
                .id(marksDto.getId())
                .user_id(marksDto.getUserId())
                .subject_id(marksDto.getSubjectId())
                .mark(marksDto.getMark())
                .date(marksDto.getDate())
                .build();
    }

    private MarkDto convertToMarkDto(Mark mark) {
        return MarkDto.builder()
                .id(mark.getId())
                .userId(mark.getUser_id())
                .subjectId(mark.getSubject_id())
                .mark(mark.getMark())
                .date(mark.getDate())
                .build();
    }

    @Data
    @Builder
    @NoArgsConstructor()
    @AllArgsConstructor()
    class MarkDto {
        private int id;
        private int subjectId;
        private int userId;
        private int mark;
        private int rate;
        private LocalDateTime date;
    }

}
