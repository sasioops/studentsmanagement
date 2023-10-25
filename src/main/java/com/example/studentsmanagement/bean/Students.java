package com.example.studentsmanagement.bean;
//non primitive data types
//Integer
//Long
//Date
//String
//Boolean

//primitive data types
//int
//long
//boolean
//short
//char

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Students {
    private  Long studentId;
    private  String firstName;
    private String lastName;
    private String address;
    private Long contactNo;
    private String email;
    private String yearCode;

}
