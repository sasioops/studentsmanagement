package com.example.studentsmanagement.service;

import com.example.studentsmanagement.bean.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentManagementSevice {
    public List<Students> getAllStudents();
    public Students getStudentById(Long student_id);
    public Students getStudentByEmailId(String email);

    public Students getStudentByContactNo(Long contactNo);

    public ResponseEntity<Object> registerStudent(Students students);

    public List<Courses> getAllCourses();

    public Courses getCourseById(Long courseId);

    public List<Courses> getCourseByCourseCredit(Long courseCredit);

    public Boolean addNewCourse(Courses courses);

    public Boolean enrollsubjects(Enrollment enrollment);

    public List<StudentDetailsWithEnrolledCoursesWithNoDuplicates> getAllStudentDetailsWithEnrolledCourses();

}
