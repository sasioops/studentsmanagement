package com.example.studentsmanagement.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetailsWithEnrolledCourses {
    private  Long studentId;
    private  String firstName;
    private String lastName;
    private String address;
    private Long contactNo;
    private String email;
    private String yearCode;
    private Long courseId;
    private String courseDescription;
    private Long courseCredit;
    private String courseType;
}
