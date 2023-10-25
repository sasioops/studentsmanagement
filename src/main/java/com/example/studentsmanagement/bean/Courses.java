package com.example.studentsmanagement.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Courses {
    private Long courseId;
    private String courseDescription;
    private Long courseCredit;
    private String courseType;

}
