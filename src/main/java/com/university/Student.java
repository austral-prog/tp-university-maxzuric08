package com.university;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Student implements Generate_Csv {
        private String Student_Name;
        private String Subject;
        private String Student_Email;
        private static Map<String, List<String>> courses = new HashMap<>();
        public Student(String Student_Name, String Subject, String Student_Email){
            this.Student_Name = Student_Name;
            this.Subject = Subject;
            this.Student_Email = Student_Email;
        }
        public String getStudent_Name() {
            return Student_Name;
        }

        public void add_Subject() {
            if (!courses.containsKey(Student_Name)) {
                List<String> list_courses = new ArrayList<String>();
                list_courses.add(Subject);
                courses.put(Student_Name,list_courses);
            }
            else if (courses.containsKey(Student_Name) && (!courses.get(Student_Name).contains(Subject))){
                List<String> list_courses = courses.get(Student_Name);
                list_courses.add(Subject);}
        }
        public String Write_Csv() {
            String archivoCSV = "src/main/resources/solution.csv";
            String[] cabecera = {"Student_Name","Course_Count"};
            List<String[]> datos = new ArrayList<>();
            for (Map.Entry<String, List<String>> entry : courses.entrySet()){
                Integer courses_amount=entry.getValue().size();
                datos.add(new String[]{entry.getKey(), courses_amount.toString()});
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

