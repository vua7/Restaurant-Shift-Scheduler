package com.example.a395_team_ritchie;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

/**
 * This class creates the Student object. It contains the methods required to obtain all the
 * necessary information regarding the student.
 */
@Entity(tableName = "student")
public class Student {
    //Instance Variables
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "openCapable")
    public boolean openCapable;

    @ColumnInfo(name = "closeCapable")
    public boolean closeCapable;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "dates")
    public ArrayList<Integer> dates;

    //Constructor
    Student(){
        dates = new ArrayList<>();
        openCapable = false;
        closeCapable = false;
    }

    /**
     * This method sets the name of the student
     * @param newName name of the student
     */
    public void setStudentName(String newName){
        name = newName;
    }

    /**
     * This method returns the name of the student
     * @return string containing the name of the student
     */
    public String getName(){
        return name;
    }

    /**
     * This method sets the ID of the student
     * @param newID ID of the student
     */
    public void setStudentID(int newID){
        id = newID;
    }

    /**
     * This method returns the ID of the student
     * @return string containg the ID of the student
     */
    public int getID(){
        return id;
    }

    /**
     * This method updates if the student is capable of opening
     */
    public void canOpen(){
        openCapable = true;
    }

    /**
     * This method updates if the student is capable of closing
     */
    public void canClose(){
        closeCapable = true;
    }

    /**
     * This method indicates of the student is capable of opening and closing
     * @return true if the student can open and close, false if not
     */
    public boolean canOpenClose(){
        return openCapable && closeCapable;
    }

    /**
     * This method sets the students email
     * @param newEmail the email to be stored
     */
    public void setEmail(String newEmail){
        email = newEmail;
    }

    /**
     * This method gets the students email
     * @return the email
     */
    public String getEmail(){
        return email;
    }

    /**
     * This method sets the students available dates
     * @param newDates the dates to be stored
     */
    public void setDates(ArrayList<Integer> newDates){
        dates = newDates;
    }

    /**
     * This method returns a copy of the dates list
     * @return the dates list
     */
    public List<Integer> getDates(){
        List<Integer> temp = new ArrayList<>();
        temp = dates;
        return temp;
    }

    /**
     * This method overrides the equals method so this Object can me compared
     * @param obj the object to be compared
     * @return true if the objects are the same, false if not
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Student)
            return this.name.equals(((Student) obj).name);
        return false;
    }

    /**
     * This method prints the object
     * @return string of the object
     */
    @Override
    public String toString() {
        StringBuilder newString = new StringBuilder();
        newString.append("Name: ");
        newString.append(name);
        newString.append("\n");
        newString.append("ID: ");
        newString.append(id);
        newString.append("\n");
        newString.append("Email: ");
        newString.append(email);
        newString.append("\n");
        newString.append("Can Open: ");
        if (openCapable)
            newString.append("Qualified");
        else
            newString.append("Unqualified");
        newString.append("\n");
        newString.append("Can Close: ");
        if (closeCapable)
            newString.append("Qualified");
        else
            newString.append("Unqualified");
        newString.append("\n");
        if (canOpenClose())
            newString.append("Can Open and Close: Qualified\n");
        newString.append("Dates available: ");
        newString.append(dates);
        newString.append("\n");
        return newString.toString();
    }
}
