package com.university;
import com.university.data.Grades;
import com.university.data.Student;
import com.university.data.Subjects;
import com.university.data.University;
import com.university.tools.CSV;
import com.university.tools.Student_Csv;

import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) {
        CSV new_csv = new CSV("src/main/resources/input.csv");
        List<List<String>> student_data = new_csv.ReadCsv();
        University university_data = new University();
        Subjects new_subjects = new Subjects();
        new_subjects.add_Subject(student_data);
        List<Student> student_list = university_data.get_student_list();
        Map<List<String>, List<String>> student_subjects = new_subjects.get_subjetcs();
        university_data.add_student(student_subjects);
        Student_Csv new_studentCsv = new Student_Csv();
        new_studentCsv.Write_Csv(student_list);



        //Student new_student = new Student("Olivia Red", "Political Science", "olivia.red@student.org");
        //new_student.Write_Csv();
        //CSV new_csv1 = new CSV("src/main/resources/input_2.csv");
        //List<List<String>> grades_data = new_csv1.ReadCsv();
        //new_data.add_grades(grades_data);
        //Grades new_grade = new Grades("Paul Beige", "English", "WRITTEN_EXAM", "Segundo Parcial", "Ej2", "7");
        //new_grade.Write_Csv();
    }}






