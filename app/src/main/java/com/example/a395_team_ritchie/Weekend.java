package com.example.a395_team_ritchie;

import java.util.ArrayList;

/**
 * This is the Weekend class. It implements the methods from Shifts and adds the students will work
 * the full day. As well, will remove students from the assigned shifts.
 */
public class Weekend extends Shifts{
    //Instance Variables
    private ArrayList<Student> dayShift;
    public int n = 2;

    //Constructor
    Weekend(){
        super.isBusy = false;
        super.type = "Weekend";
        this.dayShift = new ArrayList<Student>(n);
    }

    /**
     * This method adds a student to the all day shift
     * @param student the student to be added
     * @param timeOfDay a string specifying "full day"
     */
    @Override
    public void fillShift(Student student, String timeOfDay) {
        if(!isDayFull() && !dayShift.contains(student))
            dayShift.add(student);

    }

    /**
     * This methods checks if the day is full
     * @return true if the array is full, false if not
     */
    @Override
    public boolean isDayFull() {
        return dayShift.size() == n;
    }

    /**
     * This method removes a student from the array
     * @param studentName the name of the student to be removed
     */
    @Override
    public void clearShift(String studentName) {
        for(int i = 0; i < n; i++){
            String name = dayShift.get(i).getName();
            if(name.equals(studentName))
                dayShift.remove(dayShift.get(i));
        }
    }

    /**
     * This methods creates the string representation of the Weekend class
     * @return the string representation of the class
     */
    @Override
    public String toString(){
        StringBuilder newString = new StringBuilder();
        newString.append("Full Day Shift:\n");
        if(dayShift.isEmpty())
            newString.append("Empty\n");
        else{
            int temp = n - dayShift.size();
            for(int i = 0; i < dayShift.size(); i++){
                newString.append(dayShift.get(i).getName());
                newString.append("\n");
            }
            for(int j = 0; j < temp; j++){
                newString.append("Open Slot\n");
            }
        }
        return newString.toString();
    }

}
