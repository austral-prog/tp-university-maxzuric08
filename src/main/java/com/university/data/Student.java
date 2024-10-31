package com.university.data;

import com.university.tools.Generate_Csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Student {
    private String Student_Name;
    private List<String> Subject;
    //private String Student_Email;
    private static Map<String, List<String>> courses = new HashMap<>();

    public Student(String Student_Name, List<String> Subject) {
        this.Student_Name = Student_Name;
        this.Subject = Subject;
        //this.Student_Email = Student_Email;
    }

    public String getStudent_Name() {
        return Student_Name;
    }
    public List<String> getSubjetc() {
        return Subject;
    }

}


