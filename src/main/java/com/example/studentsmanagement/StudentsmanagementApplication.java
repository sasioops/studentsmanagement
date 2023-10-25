package com.example.studentsmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@Configuration
@PropertySource("classpath:query.properties")
public class StudentsmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentsmanagementApplication.class, args);
    }

}
