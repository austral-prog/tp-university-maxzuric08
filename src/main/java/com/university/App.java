package com.university;

import java.util.*;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class App {
    public static void main(String[] args) {
        List<List> baseData = new ArrayList<>();
        String rutaArchivo = "src/main/resources/input.csv"; // Cambia esto por la ruta a tu archivo

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            // Leer la primera línea (cabeceras) si es necesario
            String cabecera = br.readLine(); // Puedes omitir esto si no necesitas las cabeceras

            while (((linea = br.readLine()) != null)) {
        String[] datos = linea.split(",");

        // Asumiendo que el formato es correcto
        String classroom = datos[0].trim();
        String subject = datos[1].trim();
        String studentName = datos[2].trim();
        String studentEmail = datos[3].trim();
        String subjectTeacher = datos[4].trim();

        List<String> info = new ArrayList<>(List.of(classroom,subject,studentName,studentEmail,subjectTeacher));
        baseData.add(info);}

            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir el número de clase.");
            }
        List<Student> Students_Data = new ArrayList<>();
        for (int i = 0; i< baseData.size();i++) {
        Student new_student = new Student(baseData.get(i).get(2).toString(),baseData.get(i).get(1).toString(),baseData.get(i).get(3).toString());
        Students_Data.add(new_student);
        }
        for (int i = 0; i< baseData.size();i++) {
            Student student_record = Students_Data.get(i);
            student_record.add_Subject();
        }
        Student hola = Students_Data.get(1);
        System.out.println(hola.getCourses());

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
}

class Student extends App{
    private String Student_Name;
    private String Subject;
    private String Student_Email;
    private static Map<String,List<String>> courses = new HashMap<>();
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
            Arrays.sort(datos, Comparator.comparing(a -> a[0]));
            student_data.add(new String[]{entry.getKey(),courses_amount.toString()});
        }


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


