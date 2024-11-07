package com.university;
import com.university.data.grades.Grades;
import com.university.data.student.Student;
import com.university.data.student.StudentSubjects;
import com.university.data.University;
import com.university.csv.CSV;
import com.university.csv.Grade_Csv;
import com.university.data.grades.Sort_grades;
import com.university.csv.Student_Csv;
import com.university.data.student.Subject;

import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) {
        Student_Csv new_studentCsv = new Student_Csv("src/main/resources/input.csv");
        List<List<String>> student_data = new_studentCsv.ReadCsv();
        University university_data = new University();
        StudentSubjects new_subjects = new StudentSubjects();
        new_subjects.order_info(student_data);
        Map<String, List<Subject>> student_subjects = new_subjects.get_subjetcs();
        university_data.add_studentsubjects(student_subjects);
        Map<Student,List<Subject>> university_student_subject = university_data.get_studentSubject_list();
        new_studentCsv.WriteCsv(university_student_subject);
        Grade_Csv new_csv1 = new Grade_Csv("src/main/resources/input_2.csv");
        List<List<String>> grades_data = new_csv1.ReadCsv();
        Sort_grades new_grades_per_eval = new Sort_grades();
        new_grades_per_eval.order_info(grades_data);
        Map<List<String>, List<String>> student_grades = new_grades_per_eval.get_grades();
        new_csv1.WriteCsv(student_grades);
        university_data.add_grades(student_grades);
        //CSV new_csv2 = new CSV("src/main/resources/input_3.csv");
    }}






