package com.university.tools;

import com.university.data.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Student_Csv{
    public String Write_Csv(List<Student> student_data) {
        String archivoCSV = "src/main/resources/solution.csv";
        String[] cabecera = {"Student_Name","Course_Count"};
        List<String[]> datos = new ArrayList<>();
        for (Student student : student_data){
            Integer courses_amount=student.getSubjetc().size();
            datos.add(new String[]{student.getStudent_Name(), courses_amount.toString()});
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

