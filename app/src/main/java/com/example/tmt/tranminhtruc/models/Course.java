package com.example.tmt.tranminhtruc.models;

/**
 * Created by tmtruc on 19/04/2017.
 */

public class Course {

    private String courseName;
    private int courseImage;

    public Course(String courseName, int courseImage) {
        this.courseName = courseName;
        this.courseImage = courseImage;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(int courseImage) {
        this.courseImage = courseImage;
    }
}
