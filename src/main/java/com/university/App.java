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
        CSV new_csv = new CSV("src/main/resources/input.csv");
        List<List<String>> student_data = new_csv.ReadCsv();
        University new_data = new University();
        new_data.add_student(student_data);
        Student new_student = new Student("Olivia Red","Political Science","olivia.red@student.org");
        new_student.getCourses();
    }}







