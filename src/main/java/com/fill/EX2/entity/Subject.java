package com.fill.EX2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    private Integer subject_id;
    private String subject_name;
    private Integer rate;
}
