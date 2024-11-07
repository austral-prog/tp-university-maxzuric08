package com.university.data.student;

import java.util.*;

public class Student {
    private String Student_Name;
    //private List<String> Subject;
    //private String Student_Email;
    private static Map<String, List<String>> courses = new HashMap<>();

    public Student(String Student_Name) {
        this.Student_Name = Student_Name;
        //this.Subject = Subject;
        //this.Student_Email = Student_Email;
    }

    public String getStudent_Name() {
        return Student_Name;
    }

}


