package com.fill.EX2.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public interface MarkDaoService {

    List<MarkDto> getMarkSByUser(Integer user_id);

    Integer insertMarks(MarkDto marksDto);

    List<Integer> getTemplateMarks();

    @Data
    @Builder
    @NoArgsConstructor()
    @AllArgsConstructor()
    class MarkDto {
        private int id;
        private int subjectId;
        private String subjectName;
        private int userId;
        private String userName;
        private int mark;
        private int rate;
        private String month;
        private LocalDateTime date;
    }
}
