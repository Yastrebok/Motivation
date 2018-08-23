package com.fill.EX2.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class User {

//    @Column(name = "user_id")
    private int id;
//    @Column(name = "user_name")
    private String username;
    private String email;
    private int age;


}
