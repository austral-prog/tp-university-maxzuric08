package com.university;

import java.util.List;

public class University {
    public University(){}
    public void add_student(List<List<String>> student_info){
        for (int i = 0; i< student_info.size();i++) {
            Student new_student = new Student(student_info.get(i).get(2).toString(),student_info.get(i).get(1).toString(),student_info.get(i).get(3).toString());
            new_student.add_Subject();
            }

}}
