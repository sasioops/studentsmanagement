package com.example.studentsmanagement.dao;

import com.example.studentsmanagement.bean.Courses;
import com.example.studentsmanagement.bean.Enrollment;
import com.example.studentsmanagement.bean.StudentDetailsWithEnrolledCourses;
import com.example.studentsmanagement.bean.Students;

import java.util.List;


public interface StudentsManagementDao {
   public List<Students> getAllStudents();
    public Students getStudentById(Long studentId);
    public Students getStudentByEmailId(String email);

    public Students getStudentByContactNo(Long contactNo);

    public Boolean registerStudent(Students students);

    public List<Courses> getAllCourses();

    public Courses getCourseById(Long courseId);

    public List<Courses> getCourseByCourseCredit(Long courseCredit);

    public Boolean addNewCourse(Courses courses);

    public Boolean enrollsubjects(Enrollment enrollment);

    public List<StudentDetailsWithEnrolledCourses> getAllStudentDetailsWithEnrolledCourses();


}
