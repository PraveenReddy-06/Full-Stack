package com.klu.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Cr {
	private int rollNo;
	private String studentName;
    private String courseName;
    private int semester;

    public Cr(@Value("101")int r,@Value("Praveen") String sn) {
        this.rollNo = r;
        this.studentName = sn;
    }
    
    @Value("FSAD")
    public void setCourseName(String cn) {
    	this.courseName=cn;
    }
    
    @Value("2")
    public void setSemester(int s) {
        this.semester = s;
    }
    
    @Override
    public String toString() {
    	return "Cr [rollNo=" + rollNo + ", studentName=" + studentName + ", courseName=" + courseName + ", semester=" + semester + "]";
    }

}
