package com.yzx.yzxpractice.module.Retrofit_RxJava.model;

import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */

public class Student {
    private String name;

    public Student(String name, List<Course> courseList) {
        this.name = name;
        this.courseList = courseList;
    }

    private List<Course> courseList;


    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}

