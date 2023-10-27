package com.example.studentsmanagement.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.PrimitiveIterator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {

    private Long enrollmentId;
    private Long studentId;

    private Long courseId;

    private Date enrollmentDate;

    private Boolean isActive;
}
