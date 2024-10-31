package com.university.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class University {
    private static List<Student> students = new ArrayList<Student>();

    public void add_student(Map<List<String>,List<String>> subjects) {
        for (Map.Entry<List<String>, List<String>> entry : subjects.entrySet()) {
            Student new_student = new Student(entry.getKey().getFirst(), entry.getValue());
            students.add(new_student);
        }
    }
    public List<Student> get_student_list(){
        return students;
    }
    public void add_grades(List<List<String>> grades_info){
        for (int i= 0; i < grades_info.size(); i++) {
            Grades new_grade = new Grades(grades_info.get(i).get(0), grades_info.get(i).get(1), grades_info.get(i).get(2), grades_info.get(i).get(3), grades_info.get(i).get(4), grades_info.get(i).get(5));
            new_grade.add_Grade();
        }
    }
}
