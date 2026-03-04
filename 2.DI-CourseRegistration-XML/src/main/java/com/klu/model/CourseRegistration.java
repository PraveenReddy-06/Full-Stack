package com.klu.model;

public class CourseRegistration {
    private int rollNo;
    private String studentName;
    private String courseName;
    private int semester;

    public CourseRegistration(int r, String sn) {
        this.rollNo = r;
        this.studentName = sn;
    }

    public void setCourseName(String cn) {
        this.courseName = cn;
    }

    public void setSemester(int s) {
        this.semester = s;
    }

    public void display() {
        System.out.println("RollNO: " + rollNo);
        System.out.println("Name: " + studentName);
        System.out.println("Course: " + courseName);
        System.out.println("Semester: " + semester);
    }
}
