package com.university.tools;

import java.util.List;

public class Written_Exam implements Final_Value{
    public Double get_value(List<String> grades){
        Double final_grade = 0.0;
        for (String grade : grades){
            Double grade_doub= Double.parseDouble(grade);
            final_grade+=grade_doub;
        }
        Double avarage_grade = final_grade/grades.size();
        return avarage_grade;
    }
}
