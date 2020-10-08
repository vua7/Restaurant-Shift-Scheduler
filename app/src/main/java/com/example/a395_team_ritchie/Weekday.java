package com.example.a395_team_ritchie;

import java.util.ArrayList;

/**
 * This is the Weekday class. It implements the Shifts interface and uses data structures that will
 * hold the correct number of needed students.
 */
public class Weekday implements Shifts{
    //Instance Variables
    private ArrayList<Student> morningShift;
    private ArrayList<Student> afternoonShift;
    public int n = 2;

    //Constructor
    Weekday(){
        morningShift = new ArrayList<Student>(n);
        afternoonShift = new ArrayList<Student>(n);
    }

    /**
     * This method fills in the shift with the specified student.
     * @param student the student to be added
     * @param timeOfDay the time of day they will work
     */
    @Override
    public void fillShift(Student student, String timeOfDay) {
        String temp = timeOfDay.toLowerCase();
        if(!isDayFull()){
            if(temp.equals("morning")){
                if(!morningShiftFull() && !morningShift.contains(student) && !afternoonShift.contains(student))
                    morningShift.add(student);
            }
            else{
                if(!afternoonShiftFull() && !morningShift.contains(student) && !afternoonShift.contains(student))
                    afternoonShift.add(student);
            }
        }
    }

    /**
     * This method checks to see if the day is full
     * @return true if all the shifts are filled, false if they are not
     */
    @Override
    public boolean isDayFull() {
        return morningShift.size() == n && afternoonShift.size() == n;
    }

    /**
     * This method removes a student from their shift
     * @param studentName the student who is being removed
     */
    @Override
    public void clearShift(String studentName) {
        for(int i = 0; i < n; i++){
            String name1 = morningShift.get(i).getName();
            String name2 = afternoonShift.get(i).getName();
            if(studentName.equals((name1)))
                morningShift.remove(morningShift.get(i));
            else if(studentName.equals(name2))
                afternoonShift.remove(afternoonShift.get(i));
        }

    }

    /**
     * This method checks to see if the morning shift is full
     * @return true is the shifts are full, false if it is not
     */
    public boolean morningShiftFull() {
        return morningShift.size() == n;
    }

    /**
     * Checks to see if the afternoon shift is full.
     * @return true if the shift is full, false if it is not.
     */
    public boolean afternoonShiftFull() {
        return afternoonShift.size() == n;
    }

    /**
     * This method creates the string representation of the object.
     * @return the string representation of the object
     */
    @Override
    public String toString(){
        StringBuilder newString = new StringBuilder();
        newString.append("Morning Shift:\n");
        if(morningShift.isEmpty())
            newString.append("Empty\n");
        else{
            int temp = n - morningShift.size();
            for(int i = 0; i < morningShift.size(); i++){
                newString.append(morningShift.get(i).getName());
                newString.append("\n");
            }
            for(int j = 0; j < temp; j++){
                newString.append("Open Slot\n");
            }
        }
        newString.append("Afternoon Shift:\n");
        if(afternoonShift.isEmpty())
            newString.append("Empty\n");
        else{
            int temp = n - afternoonShift.size();
            for(int i = 0; i < afternoonShift.size(); i++){
                newString.append(afternoonShift.get(i).getName());
                newString.append("\n");
            }
            for(int j = 0; j < temp; j++){
                newString.append("Open Slot\n");
            }
        }
        return newString.toString();
    }
}
