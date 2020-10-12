package com.example.a395_team_ritchie;

import androidx.room.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * This class creates a Students object. It contains Student objects and provides methods to interact with the list of Student objects.
 */
public class Students {

    private int studentTotal = 0;
    private List<Student> studentList = new ArrayList<>();

    /**
     * This method adds students to the list of Student objects
     * @param studentName is the name of student
     */
    public void addStudent (String studentName) {

        Student temp = new Student(); //create new Student object
        temp.setStudentName(studentName); //sets the fields of Student object
        studentList.add(temp); //add student object to the list

        studentTotal += 1; //adjust studentTotal after add
    }

    /**
     * This method removes students from the list of Student objects
     * @param studentName is the name of student
     */
    public void removeStudent (String studentName) {

        //really bad and inefficient algorithm to find student
        int size = studentList.size();
        for (int i = 0; i < size; i++) { //traverse through whole list (probably a bad idea)
            if (studentList.get(i).getName().equals(studentName)) {
                studentList.remove(i); //remove student object from the list
                break;
            }
        }

        studentTotal -= 1; //adjust studentTotal after remove
    }

    public Student getStudent (String studentName) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().equals(studentName)) {
                return studentList.get(i);
            }
        }
        return null;
    }

}
