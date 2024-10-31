package com.university.tools;

import java.util.Collections;
import java.util.List;

public class Criteria_Type {
    public String get_value(String criteria, List<String> numbers){
        if (criteria == "AVERAGE_ABOVE_VALUE"){
            Integer value = 0;
            for (String number : numbers){
                value+=Integer.parseInt(number);}
            double avarage = value/numbers.size();
            return Double.toString(avarage);}
        else if (criteria == "MAX_ABOVE_VALUE") {
            String max_value = Collections.max(numbers);
            return max_value;}
        else if (criteria == "MIN_ABOVE_VALUE") {
            String min_value = Collections.max(numbers);
            return min_value;}
        else return "0";
    }
}
