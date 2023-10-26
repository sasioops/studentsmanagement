package com.example.studentsmanagement.dao;

import com.example.studentsmanagement.bean.Courses;
import com.example.studentsmanagement.bean.Students;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentsManagementDaoImpl implements StudentsManagementDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Value("${queryToInsertStudents}")
    private String queryToInsertStudents;

    @Value("${queryToInsertCourses}")
    private String queryToInsertCourses;

    @Value("${queryToGetAllStudents}")
    private String queryToGetAllStudents;

    @Value("${queryToGetAllCourses}")
    private String queryToGetAllCourses;

    @Value("${queryToGetStudentByStudentId}")
    private String queryToGetStudentByStudentId;

    @Value(("${queryToGetStudentByEmailId}"))
    private String queryToGetStudentByEmailId;

    @Value("${queryToGetStudentByContactNo}")
    private String queryToGetStudentByContactNo;

    @Value("${querytogetcoursesbycourseid}")
    private String querytogetcoursesbycourseid;

    @Value("${queryToGetCoursesByCourseCredit}")
    private String queryToGetCoursesByCourseCredit;
    @Value("${quertToCreateCourses}")
    private String quertToCreateCourses;
    @Value("${queryToCreateEnrollments}")
    private String queryToCreateEnrollments;
    @Value("${queryToCreateStudents}")
    private String queryToCreateStudents;

    @PostConstruct
    public void initiate() {

        namedParameterJdbcTemplate.update(queryToCreateStudents,new MapSqlParameterSource());
        namedParameterJdbcTemplate.update(quertToCreateCourses,new MapSqlParameterSource());
        namedParameterJdbcTemplate.update(queryToCreateEnrollments,new MapSqlParameterSource());
    }


    @Override
    public List<Students> getAllStudents() {

        return namedParameterJdbcTemplate.query(queryToGetAllStudents, new BeanPropertyRowMapper<Students>(Students.class));
    }

    @Override
    public Students getStudentById(Long studentId) {

        return namedParameterJdbcTemplate.queryForStream(queryToGetStudentByStudentId,
                new MapSqlParameterSource().addValue("studentId", studentId),
                new BeanPropertyRowMapper<Students>(Students.class)).findAny().orElse(new Students());
    }

    @Override
    public Students getStudentByEmailId(String email) {
        return namedParameterJdbcTemplate.queryForStream(queryToGetStudentByEmailId, new MapSqlParameterSource().addValue("email", email), new BeanPropertyRowMapper<Students>(Students.class)).findAny().orElse(new Students());
    }

    @Override
    public Students getStudentByContactNo(Long contactNo) {

        return namedParameterJdbcTemplate.queryForStream(queryToGetStudentByContactNo, new MapSqlParameterSource().addValue("contactNo", contactNo), new BeanPropertyRowMapper<Students>(Students.class)).findAny().orElse(new Students());
    }

    @Override
    public Boolean registerStudent(Students students) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("firstName", students.getFirstName());
        mapSqlParameterSource.addValue("lastName", students.getLastName());
        mapSqlParameterSource.addValue("contactNo", students.getContactNo());
        mapSqlParameterSource.addValue("address", students.getAddress());
        mapSqlParameterSource.addValue("email", students.getEmail());
        mapSqlParameterSource.addValue("yearCode", students.getYearCode());

        return namedParameterJdbcTemplate.update(queryToInsertStudents, mapSqlParameterSource) > 0;
    }

    @Override
    public List<Courses> getAllCourses() {

        return namedParameterJdbcTemplate.query(queryToGetAllCourses, new BeanPropertyRowMapper<Courses>(Courses.class));
    }

    @Override
    public Courses getCourseById(Long courseId) {

        return namedParameterJdbcTemplate.queryForStream(querytogetcoursesbycourseid, new MapSqlParameterSource().addValue("courseId", courseId), new BeanPropertyRowMapper<Courses>(Courses.class)).findAny().orElse(new Courses());
    }

    @Override
    public List<Courses> getCourseByCourseCredit(Long courseCredit) {
        return namedParameterJdbcTemplate.query(queryToGetCoursesByCourseCredit,
                new MapSqlParameterSource().addValue("courseCredit", courseCredit),
                new BeanPropertyRowMapper<Courses>(Courses.class)
        );
    }

    @Override
    public Boolean addNewCourse(Courses courses) {


        return namedParameterJdbcTemplate.update(queryToInsertCourses, new BeanPropertySqlParameterSource(courses)) > 0;
    }


}
