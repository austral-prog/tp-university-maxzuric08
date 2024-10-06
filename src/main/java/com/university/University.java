package com.university;

import java.util.List;

public class University {
    public University() {
    }

    public void add_student(List<List<String>> student_info) {
        for (int i = 0; i < student_info.size(); i++) {
            Student new_student = new Student(student_info.get(i).get(2), student_info.get(i).get(1), student_info.get(i).get(3));
            new_student.add_Subject();
        }
    }
    public void add_grades(List<List<String>> grades_info){
        for (int i= 0; i < grades_info.size(); i++) {
            Grades new_grade = new Grades(grades_info.get(i).get(0), grades_info.get(i).get(1), grades_info.get(i).get(2), grades_info.get(i).get(3), grades_info.get(i).get(4), grades_info.get(i).get(5));
            new_grade.add_Grade();
        }
    }
}
