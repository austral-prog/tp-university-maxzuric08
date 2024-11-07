package com.university.tools;

import java.util.List;

public class Practical_Work implements Final_Value{
    public Double get_value(List<String> grades){
        Double final_grade = Double.parseDouble(grades.getLast());
        return final_grade;
    }
}
