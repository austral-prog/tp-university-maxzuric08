package com.university;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Student {
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
    public static String[][] AddListaADatos(String[][] datosExistentes, List<String[]> nuevaLista) {
        // Crear un nuevo array con el tamaño adecuado
        String[][] nuevoArray = new String[datosExistentes.length + nuevaLista.size()][];

        // Copiar los datos existentes al nuevo array
        System.arraycopy(datosExistentes, 0, nuevoArray, 0, datosExistentes.length);

        // Copiar los nuevos datos al nuevo array
        for (int i = 0; i < nuevaLista.size(); i++) {
            nuevoArray[datosExistentes.length + i] = nuevaLista.get(i);
        }

        return nuevoArray;
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
        public String getCourses() {
            String archivoCSV = "src/main/resources/solution.csv";

            // Datos a escribir
            String[] cabecera = {"Student_Name","Course_Count"};
            String[][] datos = {};
            for (Map.Entry<String, List<String>> entry : courses.entrySet()){
                List<String[]> student_data=new ArrayList<>();
                Integer courses_amount=entry.getValue().size();
                student_data.add(new String[]{entry.getKey(),courses_amount.toString()});
                datos = AddListaADatos(datos,student_data);
                Arrays.sort(datos, Comparator.comparing(a -> a[0]));}
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoCSV))) {
                // Escribir la cabecera
                writer.write(String.join(",", cabecera));
                writer.newLine();

                // Escribir los datos
                for (String[] fila : datos) {
                    writer.write(String.join(",", fila));
                    writer.newLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return archivoCSV;}}

