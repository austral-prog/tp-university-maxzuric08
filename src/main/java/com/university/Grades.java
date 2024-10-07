package com.university;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Grades implements Generate_Csv{
    private String Student_Name;
    private String Subject;
    private String Evaluation_Type;
    private String Evaluation_Name;
    private String Exercise_Name;
    private String Grade;
    private static Map<List<String>, List<String>> grades_data = new HashMap<>();

    public Grades(String Student_Name, String Subject, String Evaluation_Type, String Evaluation_Name, String Exercise_Name, String Grade) {
        this.Student_Name = Student_Name;
        this.Subject = Subject;
        this.Evaluation_Type = Evaluation_Type;
        this.Evaluation_Name = Evaluation_Name;
        this.Exercise_Name = Exercise_Name;
        this.Grade = Grade;
    }
    public void add_Grade() {
        List<String> new_data = new ArrayList<>(List.of(Evaluation_Type,Subject,Evaluation_Name,Student_Name));
        if (!grades_data.containsKey(new_data)) {
            List<String> list_courses = new ArrayList<String>();
            list_courses.add(Grade);
            grades_data.put(new_data,list_courses);
        }
        else {grades_data.get(new_data).add(Grade);}}

    public String Write_Csv() {
        String archivoCSV = "src/main/resources/solution_2.csv";
        String[] cabecera = {"Subject_Name","Evaluation_Name","Student_Name","Grade"};
        List<String[]> datos = new ArrayList<>();
        for (Map.Entry<List<String>, List<String>> entry : grades_data.entrySet()){
            List<String> exc_notes=entry.getValue();
            Double final_grade = 0.0;
            for (String ind_notes : exc_notes){final_grade+=Double.parseDouble(ind_notes);}
            String data_in_string = String.join(",",entry.getKey().subList(1,entry.getKey().size()));
            datos.add(new String[]{data_in_string, Double.toString(final_grade/exc_notes.size())});}
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


