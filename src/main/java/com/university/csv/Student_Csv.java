package com.university.csv;

import com.university.data.student.Student;
import com.university.data.student.Subject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Student_Csv extends CSV<Student,Subject>{
    public Student_Csv(String Csv_toread) {
        super(Csv_toread);
    }

    public String WriteCsv(Map<Student,List<Subject>> student_data) {
        String archivoCSV = "src/main/resources/solution.csv";
        String[] cabecera = {"Student_Name","Course_Count"};
        List<String[]> datos = new ArrayList<>();
        for (Map.Entry<Student, List<Subject>> entry : student_data.entrySet()){
            Integer courses = entry.getValue().size();
            datos.add(new String[]{entry.getKey().getStudent_Name(), courses.toString()});
        }
        String[][] datosArray = datos.toArray(new String[0][]);
        Arrays.sort(datosArray, Comparator.comparing(a -> a[0]));

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

