package com.university.data.grades;


public class Grades {
    private String Student_Name;
    private String Subject;
    private String Evaluation_Name;
    private String  Grade;

    public Grades(String Student_Name, String Subject, String Evaluation_Name, String Grade) {
        this.Student_Name = Student_Name;
        this.Subject = Subject;
        this.Evaluation_Name = Evaluation_Name;
        this.Grade = Grade;
    }
    public String getSubject(){
        return Subject;
    }
    public String getEvaluation_Name(){
        return Evaluation_Name;
    }
    public String getGrade(){
        return Grade;
    }
    public String getStudent_Name(){
        return Student_Name;
    }
}




