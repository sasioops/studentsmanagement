package com.example.studentsmanagement.service;

import com.example.studentsmanagement.bean.*;
import com.example.studentsmanagement.dao.StudentsManagementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentManagementServiceImpl implements  StudentManagementSevice{
    @Autowired
    StudentsManagementDao studentsManagementDao;
    @Override
    public List<Students> getAllStudents() {
        return studentsManagementDao.getAllStudents();
    }

    @Override
    public Students getStudentById(Long studentId) {

        return studentsManagementDao.getStudentById(studentId);
    }

    @Override
    public Students getStudentByEmailId(String email) {

        return studentsManagementDao.getStudentByEmailId(email);
    }

    @Override
    public Students getStudentByContactNo(Long contactNo) {

        return studentsManagementDao.getStudentByContactNo(contactNo);
    }

    @Override
    public ResponseEntity<Object> registerStudent(Students students) {
        if(students.getFirstName()==null && students.getLastName()==null && students.getEmail()==null && students.getAddress()==null && students.getContactNo()==null && students.getYearCode()==null) {
            return new ResponseEntity<>("please give the required fields", HttpStatus.BAD_REQUEST);
        }
        try {
            return new ResponseEntity<>(studentsManagementDao.registerStudent(students), HttpStatus.OK);
        }
        catch (Exception e){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        }

    @Override
    public List<Courses> getAllCourses() {
        return studentsManagementDao.getAllCourses();
    }

    @Override
    public Courses getCourseById(Long courseId) {
        return studentsManagementDao.getCourseById(courseId);
    }

    @Override
    public List<Courses> getCourseByCourseCredit(Long courseCredit) {
        return studentsManagementDao.getCourseByCourseCredit(courseCredit);
    }

    @Override
    public Boolean addNewCourse(Courses courses) {
        return studentsManagementDao.addNewCourse(courses);
    }

    @Override
    public Boolean enrollsubjects(Enrollment enrollment) {
        return studentsManagementDao.enrollsubjects(enrollment) ;
    }

    public List<StudentDetailsWithEnrolledCoursesWithNoDuplicates> getAllStudentDetailsWithEnrolledCourses(){
        Set<Long> studentIdSet=new HashSet<>();
        List<Courses> coursesList=null;
        Students students=null;
        List <StudentDetailsWithEnrolledCoursesWithNoDuplicates> studentDetailsWithEnrolledCoursesWithNoDuplicatesList=new ArrayList<>();
        StudentDetailsWithEnrolledCoursesWithNoDuplicates studentDetailsWithEnrolledCoursesWithNoDuplicates=null;
        List<StudentDetailsWithEnrolledCourses> studentDetailsWithEnrolledCoursesList=studentsManagementDao.getAllStudentDetailsWithEnrolledCourses();
        for (StudentDetailsWithEnrolledCourses studentDetailsWithEnrolledCourses : studentDetailsWithEnrolledCoursesList){

           if(studentIdSet.add(studentDetailsWithEnrolledCourses.getStudentId())){
               if(studentDetailsWithEnrolledCoursesWithNoDuplicates!=null) {
                   studentDetailsWithEnrolledCoursesWithNoDuplicates.setStudents(students);
                   studentDetailsWithEnrolledCoursesWithNoDuplicates.setCoursesList(coursesList);
                   studentDetailsWithEnrolledCoursesWithNoDuplicatesList.add(studentDetailsWithEnrolledCoursesWithNoDuplicates);

               }
               students=new Students();
               coursesList=new ArrayList<>();
               studentDetailsWithEnrolledCoursesWithNoDuplicates=new StudentDetailsWithEnrolledCoursesWithNoDuplicates();

             students.setStudentId(studentDetailsWithEnrolledCourses.getStudentId());
             students.setAddress(studentDetailsWithEnrolledCourses.getAddress());
             students.setEmail(studentDetailsWithEnrolledCourses.getEmail());
             students.setLastName(studentDetailsWithEnrolledCourses.getLastName());
             students.setFirstName(studentDetailsWithEnrolledCourses.getFirstName());
             students.setYearCode(studentDetailsWithEnrolledCourses.getYearCode());
             students.setContactNo(studentDetailsWithEnrolledCourses.getContactNo());

           }

           Courses courses=new Courses();
           courses.setCourseId(studentDetailsWithEnrolledCourses.getCourseId());
           courses.setCourseCredit(studentDetailsWithEnrolledCourses.getCourseCredit());
           courses.setCourseDescription(studentDetailsWithEnrolledCourses.getCourseDescription());
           courses.setCourseType(studentDetailsWithEnrolledCourses.getCourseType());
           coursesList.add(courses);


        }
        studentDetailsWithEnrolledCoursesWithNoDuplicates.setStudents(students);
        studentDetailsWithEnrolledCoursesWithNoDuplicates.setCoursesList(coursesList);
        studentDetailsWithEnrolledCoursesWithNoDuplicatesList.add(studentDetailsWithEnrolledCoursesWithNoDuplicates);

  return  studentDetailsWithEnrolledCoursesWithNoDuplicatesList;  }



}
