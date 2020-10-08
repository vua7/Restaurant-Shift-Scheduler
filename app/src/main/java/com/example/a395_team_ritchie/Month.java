package com.example.a395_team_ritchie;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the Month class. It is used for storing the the shifts and printing them out.
 */
public class Month {
    //Instance Variable
    private List<Shifts> shifts;
    private String month;
    private String year;

    //Constructor
    Month(String month, String year){
        this.month = month;
        this.year = year;
        shifts = new ArrayList<>();
    }

    /**
     * This method adds a shift to the list of Shifts
     * @param shift the Shift to be added
     */
    public void addShift(Shifts shift){
        shifts.add(shift);
    }

    /**
     * This methods prints the Shifts
     */
    public void printShifts(){
        System.out.print(month + " " + year + " Shifts\n");
        for(int i = 0; i < shifts.size(); i++){
            System.out.print(shifts.get(i));
        }
    }
}
