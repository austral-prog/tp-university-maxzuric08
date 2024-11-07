package com.university.tools;

import java.util.List;

public class Final_Prac_Work implements Final_Value{
    public Double get_value(List<String> grades){
        Integer final_grade = 0;
        for (String grade : grades){
            Integer grade_int= Integer.parseInt(grade);
            final_grade+=grade_int;
        }
        return Double.valueOf(final_grade);
    }
}
