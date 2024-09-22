package com.learn.SpringJDBCEx.model;

import org.springframework.stereotype.Service;

@Service
public class Student {

    private int rollNum;
    private String name;
    private int marks;

    public int getRollNum() {
        return rollNum;
    }

    public void setRollNum(int rollNum) {
        this.rollNum = rollNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNum=" + rollNum +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}' + '\n';
    }
}
