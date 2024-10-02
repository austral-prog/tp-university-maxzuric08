package com.university;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


class Student {
    private String Student_Name;
    private List<String> Subjects;
    private String Student_Email;
    public Student(String Student_Name, List<String> Subjects, String Student_Email){
        this.Student_Name = Student_Name;
        this.Subjects = Subjects;
        this.Student_Email = Student_Email;
    }
    public String getStudent_Name(){
        return Student_Name;
    }
}
public class App {
    public static void main(String[] args) {
        List<Object> baseData = new ArrayList<>();
        Integer a = 0;
        String rutaArchivo = "src/main/resources/input.csv"; // Cambia esto por la ruta a tu archivo

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            // Leer la primera línea (cabeceras) si es necesario
            String cabecera = br.readLine(); // Puedes omitir esto si no necesitas las cabeceras

            while (((linea = br.readLine()) != null) && (a < 2)) {
        String[] datos = linea.split(",");

        // Asumiendo que el formato es correcto
        int classroom = Integer.parseInt(datos[0].trim());
        String subject = datos[1].trim();
        String studentName = datos[2].trim();
        String studentEmail = datos[3].trim();
        String subjectTeacher = datos[4].trim();

        baseData.add(classroom);
        baseData.add(subject);
        baseData.add(studentName);
        baseData.add(studentEmail);
        baseData.add(subjectTeacher);
        baseData.add("\n");}

            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir el número de clase.");
            }
        System.out.println(baseData);
        }}

