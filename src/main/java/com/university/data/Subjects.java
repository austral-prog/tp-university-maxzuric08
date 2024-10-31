package com.university.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subjects {
    private static Map<List<String>, List<String>> subjects = new HashMap<>();

    public void add_Subject(List<List<String>> student_info) {
        for (List<String> info_per_student : student_info) {
            List<String> student_data = new ArrayList<>(List.of(info_per_student.get(2)));
            List<String> student_subject = new ArrayList<>(List.of(info_per_student.get(1)));
            String subject = info_per_student.get(1);
        if (!subjects.containsKey(student_data)) {
            subjects.put(student_data,student_subject);
            subjects.get(student_data).add(subject);
        }}}
    public Map<List<String>, List<String>> get_subjetcs(){
        return subjects;
    }
}
