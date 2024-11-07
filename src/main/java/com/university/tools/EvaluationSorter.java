package com.university.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationSorter extends Sorter {
    private static Map<List<String>, List<String>> criteria_ev = new HashMap<>();
    @Override
    public void order_info(List<List<String>> evaluation_info) {
        for (List<String> info_per_ev : evaluation_info) {
            List<String> new_data = new ArrayList<>(List.of(info_per_ev.get(0),info_per_ev.get(1),info_per_ev.get(2)));
            List<String> evaluation_names = new ArrayList<String>();
            for (int i=3; i< info_per_ev.size(); i++){
                evaluation_names.add(info_per_ev.get(i));
            }
                criteria_ev.put(new_data,evaluation_names);
            }}
        public Map<List<String>, List<String>> get_criteria_ev(){
            return criteria_ev;
        }}


