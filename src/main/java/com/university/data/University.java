package com.university.data;

import com.university.data.grades.Grades;
import com.university.data.student.Student;
import com.university.data.student.Subject;
import com.university.tools.Final_Prac_Work;
import com.university.tools.Oral_Exams;
import com.university.tools.Practical_Work;
import com.university.tools.Written_Exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class University {
    private static Map<Student,List<Subject>> studentsSubjects = new HashMap<>();
    private static List<Grades> grades_list = new ArrayList<Grades>();
    private static List<Student> students_list = new ArrayList<Student>();

    public void add_studentsubjects(Map<String,List<Subject>> subjects) {
        for (Map.Entry<String, List<Subject>> entry : subjects.entrySet()) {
            Student new_student = new Student(entry.getKey());
            add_student(entry.getKey());
            studentsSubjects.put(new_student,entry.getValue());
        }
    }
    public void add_student(String student_name){
        Student new_student = new Student(student_name);
    }
    public Map<Student, List<Subject>> get_studentSubject_list(){
        return studentsSubjects;
    }
    public void add_grades(Map<List<String>,List<String>> grades){
        for (Map.Entry<List<String>, List<String>> entry : grades.entrySet()) {
            String exam = entry.getKey().getFirst();
            Double final_grade = 0.0;
            if (exam.equals("WRITTEN_EXAM")){
                Written_Exam written_exam = new Written_Exam();
                final_grade+=written_exam.get_value(entry.getValue());
            } else if (exam.equals("FINAL_PRACTICAL_WORK")) {
                Final_Prac_Work fpw = new Final_Prac_Work();
                final_grade+=fpw.get_value(entry.getValue());
            } else if (exam.equals("ORAL_EXAM")) {
                Oral_Exams oral_exam  = new Oral_Exams();
                final_grade+=oral_exam.get_value(entry.getValue());
            } else if (exam.equals("PRACTICAL_WORK")) {
                Practical_Work practicalWork = new Practical_Work();
                final_grade+=practicalWork.get_value(entry.getValue());
            }
            Grades new_grade = new Grades(entry.getKey().getLast(),entry.getKey().get(1),entry.getKey().get(2),final_grade.toString());
            grades_list.add(new_grade);
        }
        }
    public List<Grades> get_grades_list(){
        return grades_list;
    }

    }

