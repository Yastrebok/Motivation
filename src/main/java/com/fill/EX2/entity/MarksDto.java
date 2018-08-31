package com.fill.EX2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarksDto {

    private Integer id;
    private Integer subject_id;
    private Integer user_id;
    private Integer rate;
    private Integer mark;
    private Date date;
}
