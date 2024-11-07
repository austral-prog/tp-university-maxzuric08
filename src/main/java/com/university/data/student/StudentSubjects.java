package com.university.data.student;
import com.university.tools.Sorter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentSubjects extends Sorter{
    private static Map<String, List<Subject>> subjects = new HashMap<>();

    public void order_info(List<List<String>> student_info) {
        for (List<String> info_per_student : student_info) {
            String student_Name = info_per_student.get(2);
            Subject new_subject = new Subject(info_per_student.get(1));
            List<Subject> student_subject = new ArrayList<>(List.of(new_subject));
        if (!subjects.containsKey(student_Name)) {
            subjects.put(student_Name,student_subject);}
        else if(!subjects.get(student_Name).contains(new_subject)){subjects.get(student_Name).add(new_subject);}
        }}
    public Map<String, List<Subject>> get_subjetcs(){
        return subjects;
    }
}
