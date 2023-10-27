package com.example.studentsmanagement.controller;

import com.example.studentsmanagement.bean.*;
import com.example.studentsmanagement.service.StudentManagementSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentsManagementController {
    @Autowired
    StudentManagementSevice studentManagementSevice;

    @GetMapping("/getallstudents")
    public List<Students> getAllStudents(){
        return studentManagementSevice.getAllStudents();
    }

    @GetMapping("/getstudentbyid")
    public Students getStudentById(@RequestParam Long studentId){
        return studentManagementSevice.getStudentById(studentId);
    }

    @GetMapping("/getstudentbyemailid")
    public Students getStudentByEmailId(@RequestParam String email){
        return studentManagementSevice.getStudentByEmailId(email);


    }

    @GetMapping("/getstudentbycontactno")
    public Students getStudentByContactNo(@RequestParam Long contactNo){
        return studentManagementSevice.getStudentByContactNo(contactNo);
    }

 @PostMapping("/register/student")
    public ResponseEntity<Object> registerStudent(@RequestBody Students students){
     return   studentManagementSevice.registerStudent(students);
 }

 @GetMapping("/getallcourses")
 public List<Courses> getAllCourses(){
        return studentManagementSevice.getAllCourses();
 }

 @PostMapping("/register/course")
 public Boolean addNewCourse(@RequestBody Courses courses){
     return studentManagementSevice.addNewCourse(courses);



 }
    @GetMapping("/getcousesbycourseid")
    public Courses getCourseById(@RequestParam Long courseId){
        return studentManagementSevice.getCourseById(courseId);
    }

@GetMapping("/getcoursebycoursecredit")
public List<Courses> getCourseByCourseCredit(@RequestParam Long courseCredit){
        return studentManagementSevice.getCourseByCourseCredit(courseCredit);
}

    @PostMapping("/enrollnewsubjects")
    public Boolean enrollsubjects(@RequestBody Enrollment enrollment){
        return studentManagementSevice.enrollsubjects(enrollment);
    }

    @PostMapping("/get")
    public Courses get(){
     return new Courses();
 }

 @GetMapping("/getallstudentdetailswithenrolledcourses")
 public List<StudentDetailsWithEnrolledCoursesWithNoDuplicates> getAllStudentDetailsWithEnrolledCourses(){
        return studentManagementSevice.getAllStudentDetailsWithEnrolledCourses();
 }

}
