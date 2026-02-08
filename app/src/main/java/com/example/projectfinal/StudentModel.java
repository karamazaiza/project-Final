package com.example.projectfinal;

public class StudentModel {
    public String id;
    public String name;
    public int grade;

    // مطلوب لـ Firebase
    public StudentModel() {}

    public StudentModel(String id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // أضف هذه الدوال (الـ Getters) بالأسفل:
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }
}