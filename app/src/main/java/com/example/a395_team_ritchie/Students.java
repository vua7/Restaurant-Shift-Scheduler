package com.example.a395_team_ritchie;

import androidx.room.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * This class creates a Students object. It contains Student objects and provides methods to interact with the list of Student objects.
 */
public class Students {

    private int studentTotal = 0;
    private ArrayList<Student> studentList = new ArrayList<>();

    /**
     * This method adds students to the list of Student objects
     * @param studentName is the name of student
     */
    /*
    public void addStudent (String studentName, int id) {

        Student temp = new Student(); //create new Student object
        temp.setStudentName(studentName); //sets the fields of Student object
        temp.setStudentID(id);
        studentList.add(temp); //add student object to the list

        studentTotal += 1; //adjust studentTotal after add
    }
    */

    /**
     * This method adds a list of students to the students list
     * @param students the list of students
     */
    public void addStudents(ArrayList<Student> students){
        studentList = students;
    }

    /**
     * This method removes students from the list of Student objects
     * @param studentName is the name of student
     */
    public void removeStudent (String studentName) {
        int size = studentList.size();
        for (int i = 0; i < size; i++) { //traverse through whole list (probably a bad idea)
            if (studentList.get(i).getName().toLowerCase().equals(studentName.toLowerCase())) {
                studentList.remove(i); //remove student object from the list
                break;
            }
        }

        studentTotal -= 1; //adjust studentTotal after remove
    }

    /**
     * This method returns the student object matching the parameter
     * @param studentName
     * @return student object or null
     */
    public Student getStudent (String studentName) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().toLowerCase().equals(studentName.toLowerCase())) {
                return studentList.get(i);
            }
        }
        return null;
    }

    /**
     * This method traverses and prints all students in the Students object
     */
    public void traverseStudents () {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(this.studentList.get(i));
        }
    }

    /**
     * This method finds the student and updates their email
     * @param name the name of the student
     * @param email the students email
     */
    public void updateStudentEmail(String name, String email){
        for (int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getName().toLowerCase().equals(name.toLowerCase()))
                studentList.get(i).setEmail(email);
        }
    }

    /**
     * This method finds the student and updates their dates available to work
     * @param name the name of the student
     * @param days the dates the student is available
     */
    public void updateStudentDays(String name, ArrayList<String> days){
        for (int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getName().toLowerCase().equals(name.toLowerCase()))
                studentList.get(i).setDays(days);
        }
    }

    /**
     * This method finds the student and updates the times they can work
     * @param name the name of the student
     * @param times the times they can work
     */
    public void updateStudentTimes(String name, ArrayList<String> times){
        for (int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getName().toLowerCase().equals(name.toLowerCase()))
                studentList.get(i).setDays(times);
        }
    }

    /**
     * Update if the student is capable to open
     * @param name the name of the student
     */
    public void updateStudentOpenCapable(String name){
        for (int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getName().toLowerCase().equals(name.toLowerCase()))
                studentList.get(i).canOpen();
        }
    }

    /**
     * Update if the student is capable to close
     * @param name the name of the student
     */
    public void updateStudentCloseCapable(String name){
        for (int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getName().toLowerCase().equals(name.toLowerCase()))
                studentList.get(i).canClose();
        }
    }

    public String getStudentEmail(String name){
        for (int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getName().toLowerCase().equals(name.toLowerCase()))
                return studentList.get(i).getEmail();
        }
        return null;
    }

    /**
     * This method returns the days the student is available to work
     * @param name the name of the student
     * @return the days the student can work
     */
    public List<String> getStudentDates(String name){
        List <String> temp = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getName().toLowerCase().equals(name.toLowerCase())){
                temp = studentList.get(i).getDays();
                return temp;
            }
        }
        return null;
    }

    public List<String> getStudentTimes(String name){
        List <String> temp = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getName().toLowerCase().equals(name.toLowerCase())){
                temp = studentList.get(i).getTimes();
                return temp;
            }
        }
        return null;
    }

    /**
     * This method returns if the student is capable to open or not
     * @param name the name of the student
     * @return true if they can open, false if they can't
     */
    public boolean canStudentOpen(String name){
        for(int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getName().toLowerCase().equals(name.toLowerCase()))
                return studentList.get(i).openCapable;
        }
        return false;
    }

    /**
     * This method returns if the student is capable to close or not
     * @param name the name of the student
     * @return true if the student can open, false if they can't
     */
    public boolean canStudentClose(String name){
        for(int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getName().toLowerCase().equals(name.toLowerCase()))
                return studentList.get(i).closeCapable;
        }
        return false;
    }

    /**
     * This method returns of the student can open and close
     * @param name the name of the student
     * @return true if they can, false if they can't
     */
    public boolean canStudentOpenAndClose(String name){
        for(int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getName().toLowerCase().equals(name.toLowerCase()))
                return studentList.get(i).canOpenClose();
        }
        return false;
    }

    /**
     * This method returns the total number of students in Students object
     * @return
     */
    public int getStudentTotal() {
        return this.studentTotal;
    }
}
