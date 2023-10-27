package com.example.studentsmanagement.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetailsWithEnrolledCoursesWithNoDuplicates {
   private Students students;
   private List<Courses> coursesList;
}
