package com.university.tools;

import java.util.List;

public class Oral_Exams implements Final_Value{
    public Double get_value(List<String> grades){
        Double final_grade = Double.parseDouble(grades.getFirst());
        return final_grade;
    }
}
