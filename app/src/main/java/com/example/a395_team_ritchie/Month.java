package com.example.a395_team_ritchie;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * This is the Month class. It is used for storing the shifts and printing them out.
 */
public class Month {
    //Instance Variable
    private Shifts[] shifts;
    private String month;
    private int monthNum;
    private int year;
    private int n;

    //Constructor
    @RequiresApi(api = Build.VERSION_CODES.O)
    Month(String month, int year){
        this.month = month;
        this.year = year;

        if(this.month.toLowerCase().equals("january")) {
            n = 31;
            monthNum = 1;
            shifts = new Shifts[n];
            populateShifts();
        }
        else if(this.month.toLowerCase().equals("february")){
            monthNum = 2;
            if(this.year % 4 == 0 && (this.year % 100 != 0 || this.year % 400 == 0))
                n = 29;
            else
                n = 28;
            shifts = new Shifts[n];
            populateShifts();
        }
        else if(this.month.toLowerCase().equals("march")){
            monthNum = 3;
            n = 31;
            shifts = new Shifts[n];
            populateShifts();
        }
        else if(this.month.toLowerCase().equals("april")){
            monthNum = 4;
            n = 30;
            shifts = new Shifts[n];
            populateShifts();
        }
        else if(this.month.toLowerCase().equals("may")){
            monthNum = 5;
            n = 31;
            shifts = new Shifts[n];
            populateShifts();
        }
        else if(this.month.toLowerCase().equals("june")){
            monthNum = 6;
            n = 30;
            shifts = new Shifts[n];
            populateShifts();
        }
        else if(this.month.toLowerCase().equals("july")){
            monthNum = 7;
            n = 31;
            shifts = new Shifts[n];
            populateShifts();
        }
        else if(this.month.toLowerCase().equals("august")){
            monthNum = 8;
            n = 31;
            shifts = new Shifts[n];
            populateShifts();
        }
        else if(this.month.toLowerCase().equals("september")){
            monthNum = 9;
            n = 30;
            shifts = new Shifts[n];
            populateShifts();
        }
        else if(this.month.toLowerCase().equals("october")){
            monthNum = 10;
            n = 31;
            shifts = new Shifts[n];
            populateShifts();
        }
        else if(this.month.toLowerCase().equals("november")){
            monthNum = 11;
            n = 30;
            shifts = new Shifts[n];
            populateShifts();
        }
        else{ //"december"
            monthNum = 12;
            n = 31;
            shifts = new Shifts[n];
            populateShifts();
        }
    }

    /**
     * This method populates the array with empty shifts based on the number of days in the month
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void populateShifts() {
        for (int i = 0; i < n; i++) {
            LocalDate localDate = LocalDate.of(this.year, monthNum, i+1);
            DayOfWeek dayOfWeek = DayOfWeek.from(localDate);

            if (monthNum == 1 && i == 0) { //January 1 (New Year)
                if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) { //Weekend
                    BusyWeekend newBusyWeekend = new BusyWeekend();
                    shifts[i] = newBusyWeekend;
                }
                else { //Weekday
                    BusyWeekday newBusyWeekday = new BusyWeekday();
                    shifts[i] = newBusyWeekday;
                }
            }
            else if (monthNum == 4 && i == 9) { //April 10 (Good Friday)
                if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) { //Weekend
                    BusyWeekend newBusyWeekend = new BusyWeekend();
                    shifts[i] = newBusyWeekend;
                }
                else { //Weekday
                    BusyWeekday newBusyWeekday = new BusyWeekday();
                    shifts[i] = newBusyWeekday;
                }
            }
            else if (monthNum == 5 && i == 17) { //May 18 (Victoria Day)
                if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) { //Weekend
                    BusyWeekend newBusyWeekend = new BusyWeekend();
                    shifts[i] = newBusyWeekend;
                }
                else { //Weekday
                    BusyWeekday newBusyWeekday = new BusyWeekday();
                    shifts[i] = newBusyWeekday;
                }
            }
            else if (monthNum == 7 && i == 0) { //July 1 (Canada Day)
                if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) { //Weekend
                    BusyWeekend newBusyWeekend = new BusyWeekend();
                    shifts[i] = newBusyWeekend;
                }
                else { //Weekday
                    BusyWeekday newBusyWeekday = new BusyWeekday();
                    shifts[i] = newBusyWeekday;
                }
            }
            else if (monthNum == 9 && i == 6) { //September 7 (Labour Day)
                if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) { //Weekend
                    BusyWeekend newBusyWeekend = new BusyWeekend();
                    shifts[i] = newBusyWeekend;
                }
                else { //Weekday
                    BusyWeekday newBusyWeekday = new BusyWeekday();
                    shifts[i] = newBusyWeekday;
                }
            }
            else if (monthNum == 10 && i == 11) { //October 12 (Thanksgiving Day)
                if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) { //Weekend
                    BusyWeekend newBusyWeekend = new BusyWeekend();
                    shifts[i] = newBusyWeekend;
                }
                else { //Weekday
                    BusyWeekday newBusyWeekday = new BusyWeekday();
                    shifts[i] = newBusyWeekday;
                }
            }
            else if (monthNum == 11 && i == 10) { //November 11 (Remembrance Day)
                if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) { //Weekend
                    BusyWeekend newBusyWeekend = new BusyWeekend();
                    shifts[i] = newBusyWeekend;
                }
                else { //Weekday
                    BusyWeekday newBusyWeekday = new BusyWeekday();
                    shifts[i] = newBusyWeekday;
                }
            }
            else if (monthNum ==  12 && (i >= 17 && i <= 24)) { //December 25 (Christmas Day) and the week (7 days) before
                if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) { //Weekend
                    BusyWeekend newBusyWeekend = new BusyWeekend();
                    shifts[i] = newBusyWeekend;
                }
                else { //Weekday
                    BusyWeekday newBusyWeekday = new BusyWeekday();
                    shifts[i] = newBusyWeekday;
                }
            }
            else if (monthNum == 12 && i == 25) { //December 26 (Boxing Day)
                if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) { //Weekend
                    BusyWeekend newBusyWeekend = new BusyWeekend();
                    shifts[i] = newBusyWeekend;
                }
                else { //Weekday
                    BusyWeekday newBusyWeekday = new BusyWeekday();
                    shifts[i] = newBusyWeekday;
                }
            }
            else { //Not a holiday
                if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) { //Weekend
                    Weekend newWeekend = new Weekend();
                    shifts[i] = newWeekend;
                }
                else { //Weekday
                    Weekday newWeekday = new Weekday();
                    shifts[i] = newWeekday;
                }
            }
        }
    }

    /**
     * This method adds a student to a shift
     * @param student the student to be added
     * @param date the date to be added
     * @param timeOfDay the time of day to be added
     */
    public void addStudentToShift(Student student, int date, String timeOfDay){
        shifts[date-1].fillShift(student, timeOfDay);
    }

    /**
     * This method clears a student from the shift
     * @param name the name of the student
     */
    public void clearShift(String name){
        for(int i = 0; i < n; i++){
            shifts[i].clearShift(name);
        }
    }

    /**
     * This methods prints the Shifts
     */
    public void printShifts(){
        System.out.print(month + " " + year + " Shifts\n");
        for(int i = 0; i < n; i++){
            System.out.print(shifts[i]);
        }
    }

    /**
     * This method returns the size of the array list
     * @return the size of the list, representing the number of days
     */
    public int getSize(){
        return n;
    }
}
