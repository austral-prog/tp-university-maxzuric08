package com.university;
import java.util.Collections;
import java.util.List;


public class App {
    public static void main(String[] args) {
        CSV new_csv = new CSV("src/main/resources/input.csv");
        List<List<String>> student_data = new_csv.ReadCsv();
        University new_data = new University();
        new_data.add_student(student_data);
        Student new_student = new Student("Olivia Red", "Political Science", "olivia.red@student.org");
        CSV new_csv1 = new CSV("src/main/resources/input_2.csv");
        List<List<String>> grades_data = new_csv1.ReadCsv();
        new_data.add_grades(grades_data);
        Grades new_grade = new Grades("Paul Beige", "English", "WRITTEN_EXAM", "Segundo Parcial", "Ej2", "7");
        new_grade.Write_Csv();
    }}






