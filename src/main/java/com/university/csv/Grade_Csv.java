package com.university.csv;

import com.university.data.grades.Grades;
import com.university.tools.Final_Prac_Work;
import com.university.tools.Oral_Exams;
import com.university.tools.Practical_Work;
import com.university.tools.Written_Exam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Grade_Csv extends CSV<List<String>,String>{
    public Grade_Csv(String Csv_toread) {
        super(Csv_toread);
    }
    public String WriteCsv(Map<List<String>,List<String>> grade_data) {
        String archivoCSV = "src/main/resources/solution_2.csv";
        String[] cabecera = {"Subject_Name","Evaluation_Name","Student_Name","Grade"};
        List<String[]> datos = new ArrayList<>();
        for (Map.Entry<List<String>, List<String>> entry : grade_data.entrySet()) {
                String exam = entry.getKey().getFirst();
            Double final_grade = 0.0;
            if (exam.equals("WRITTEN_EXAM")){
                Written_Exam written_exam = new Written_Exam();
                final_grade+=written_exam.get_value(entry.getValue());
            } else if (exam.equals("FINAL_PRACTICAL_WORK")) {
                Final_Prac_Work fpw = new Final_Prac_Work();
                final_grade+=fpw.get_value(entry.getValue());
            } else if (exam.equals("ORAL_EXAM")) {
                Oral_Exams oral_exam  = new Oral_Exams();
                final_grade+=oral_exam.get_value(entry.getValue());
            } else if (exam.equals("PRACTICAL_WORK")) {
                Practical_Work practicalWork = new Practical_Work();
                final_grade+=practicalWork.get_value(entry.getValue());
            }
            datos.add(new String[]{entry.getKey().get(1),entry.getKey().get(2),entry.getKey().getLast(), final_grade.toString()});
        }
        String[][] datosArray = datos.toArray(new String[0][]);
        Arrays.sort(datosArray, (a, b) -> {
            String lineA = String.join(",", a);
            String lineB = String.join(",", b);
            return lineA.compareTo(lineB);
        });
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoCSV))) {
            // Escribir la cabecera
            writer.write(String.join(",", cabecera));
            writer.newLine();

            // Escribir los datos
            for (String[] fila : datosArray) {
                writer.write(String.join(",", fila));
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return archivoCSV;}}

