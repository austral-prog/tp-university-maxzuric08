package com.university.data.grades;
import com.university.tools.Sorter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sort_grades extends Sorter{
    private static Map<List<String>, List<String>> grades_data = new HashMap<>();
    @Override
    public void order_info(List<List<String>> grades_info) {
        for (List<String> info_per_grade : grades_info) {
        List<String> new_data = new ArrayList<>(List.of(info_per_grade.get(2),info_per_grade.get(1),info_per_grade.get(3),info_per_grade.get(0)));
        if (!grades_data.containsKey(new_data)) {
            List<String> list_of_grades = new ArrayList<String>();
            list_of_grades.add(info_per_grade.getLast());
            grades_data.put(new_data,list_of_grades);
        }
        else {grades_data.get(new_data).add(info_per_grade.getLast());}}}

    public Map<List<String>, List<String>> get_grades(){
        return grades_data;
    }}

