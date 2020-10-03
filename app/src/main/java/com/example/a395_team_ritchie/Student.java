package com.example.a395_team_ritchie;

/**
 * This class creates the Student object. It contains the methods required to obtain all the
 * necessary information regarding the student.
 */
public class Student {
    //Instance Variables
    private String name;
    private String ID;
    private boolean openCapable;
    private boolean closeCapable;

    //Constructor
    Student(){
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
    public void setStudentID(String newID){
        ID = newID;
    }

    /**
     * This method returns the ID of the student
     * @return string containg the ID of the student
     */
    public String getID(){
        return ID;
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
     * This method indicates of the student is capable of opeing and closing
     * @return true if the student can open and close, false if not
     */
    public boolean canOpenClose(){
        return openCapable && closeCapable;
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
        newString.append(ID);
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
        return newString.toString();
    }
}
