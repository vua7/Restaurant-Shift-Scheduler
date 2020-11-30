package com.example.a395_team_ritchie;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This is the Month class. It is used for storing the shifts and printing them out.
 */
public class Month {
    //Instance Variable
    private ArrayList<Shifts> shifts;
    private String month;
    private int monthNum;
    private int year;
    private int n;

    //Constructor
    @RequiresApi(api = Build.VERSION_CODES.O)
    Month(String date){
        String[] splitString = date.split("/", 2);
        this.monthNum = Integer.parseInt(splitString[1]);
        this.year = Integer.parseInt(splitString[0]);

        if(this.monthNum == 1) {
            n = 31;
            this.month = "January";
            shifts = new ArrayList<>();
            populateShifts();
        }
        else if(this.monthNum == 2){
            this.month = "February";
            if(this.year % 4 == 0 && (this.year % 100 != 0 || this.year % 400 == 0))
                n = 29;
            else
                n = 28;
            shifts = new ArrayList<>();
            populateShifts();
        }
        else if(this.monthNum == 3){
            this.month = "March";
            n = 31;
            shifts = new ArrayList<>();
            populateShifts();
        }
        else if(this.monthNum == 4){
            this.month = "April";
            n = 30;
            shifts = new ArrayList<>();
            populateShifts();
        }
        else if(this.monthNum == 5){
            this.month = "May";
            n = 31;
            shifts = new ArrayList<>();
            populateShifts();
        }
        else if(this.monthNum == 6){
            this.month = "June";
            n = 30;
            shifts = new ArrayList<>();
            populateShifts();
        }
        else if(this.monthNum == 7){
            this.month = "July";
            n = 31;
            shifts = new ArrayList<>();
            populateShifts();
        }
        else if(this.monthNum == 8){
            this.month = "August";
            n = 31;
            shifts = new ArrayList<>();
            populateShifts();
        }
        else if(this.monthNum == 9){
            this.month = "September";
            n = 30;
            shifts = new ArrayList<>();
            populateShifts();
        }
        else if(this.monthNum == 10){
            this.month = "October";
            n = 31;
            shifts = new ArrayList<>();
            populateShifts();
        }
        else if(this.monthNum == 11){
            this.month = "November";
            n = 30;
            shifts = new ArrayList<>();
            populateShifts();
        }
        else{ //"december"
            this.month = "December";
            n = 31;
            shifts = new ArrayList<>();
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
                    shifts.add(newBusyWeekend);
                }
                else { //Weekday
                    BusyWeekday newBusyWeekday = new BusyWeekday();
                    shifts.add(newBusyWeekday);
                }
            }
            else if (monthNum == 4 && i == 9) { //April 10 (Good Friday)
                if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) { //Weekend
                    BusyWeekend newBusyWeekend = new BusyWeekend();
                    shifts.add(newBusyWeekend);
                }
                else { //Weekday
                    BusyWeekday newBusyWeekday = new BusyWeekday();
                    shifts.add(newBusyWeekday);
                }
            }
            else if (monthNum == 5 && i == 17) { //May 18 (Victoria Day)
                if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) { //Weekend
                    BusyWeekend newBusyWeekend = new BusyWeekend();
                    shifts.add(newBusyWeekend);
                }
                else { //Weekday
                    BusyWeekday newBusyWeekday = new BusyWeekday();
                    shifts.add(newBusyWeekday);
                }
            }
            else if (monthNum == 7 && i == 0) { //July 1 (Canada Day)
                if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) { //Weekend
                    BusyWeekend newBusyWeekend = new BusyWeekend();
                    shifts.add(newBusyWeekend);
                }
                else { //Weekday
                    BusyWeekday newBusyWeekday = new BusyWeekday();
                    shifts.add(newBusyWeekday);
                }
            }
            else if (monthNum == 9 && i == 6) { //September 7 (Labour Day)
                if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) { //Weekend
                    BusyWeekend newBusyWeekend = new BusyWeekend();
                    shifts.add(newBusyWeekend);
                }
                else { //Weekday
                    BusyWeekday newBusyWeekday = new BusyWeekday();
                    shifts.add(newBusyWeekday);
                }
            }
            else if (monthNum == 10 && i == 11) { //October 12 (Thanksgiving Day)
                if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) { //Weekend
                    BusyWeekend newBusyWeekend = new BusyWeekend();
                    shifts.add(newBusyWeekend);
                }
                else { //Weekday
                    BusyWeekday newBusyWeekday = new BusyWeekday();
                    shifts.add(newBusyWeekday);
                }
            }
            else if (monthNum == 11 && i == 10) { //November 11 (Remembrance Day)
                if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) { //Weekend
                    BusyWeekend newBusyWeekend = new BusyWeekend();
                    shifts.add(newBusyWeekend);
                }
                else { //Weekday
                    BusyWeekday newBusyWeekday = new BusyWeekday();
                    shifts.add(newBusyWeekday);
                }
            }
            else if (monthNum ==  12 && (i >= 17 && i <= 24)) { //December 25 (Christmas Day) and the week (7 days) before
                if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) { //Weekend
                    BusyWeekend newBusyWeekend = new BusyWeekend();
                    shifts.add(newBusyWeekend);
                }
                else { //Weekday
                    BusyWeekday newBusyWeekday = new BusyWeekday();
                    shifts.add(newBusyWeekday);
                }
            }
            else if (monthNum == 12 && i == 25) { //December 26 (Boxing Day)
                if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) { //Weekend
                    BusyWeekend newBusyWeekend = new BusyWeekend();
                    shifts.add(newBusyWeekend);
                }
                else { //Weekday
                    BusyWeekday newBusyWeekday = new BusyWeekday();
                    shifts.add(newBusyWeekday);
                }
            }
            else { //Not a holiday
                if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) { //Weekend
                    Weekend newWeekend = new Weekend();
                    shifts.add(newWeekend);
                }
                else { //Weekday
                    Weekday newWeekday = new Weekday();
                    shifts.add(newWeekday);
                }
            }
        }
    }

    /**
     * This method adds a student to a shift
     * @param student the student to be added
     * @param date the date to be added
     * @param timeOfDay the time of day to be added (Morning, Afternoon, Full Day)
     */
    public void addStudentToShift(Student student, int date, String timeOfDay){
        shifts.get(date-1).fillShift(student, timeOfDay);
    }

    /**
     * This method clears a student from the shift
     * @param name the name of the student
     */
    public void clearShift(String name){
        for(int i = 0; i < n; i++){
            shifts.get(i).clearShift(name);
        }
    }

    /**
     * This methods prints the Shifts
     */
    public void printShifts(){
        System.out.print(month + " " + year + " Shifts\n");
        for(int i = 0; i < n; i++){
            System.out.print(shifts.get(i));
        }
    }

    /**
     * This method makes the day busy
     * @param date the date to be made busy
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void makeBusy(int date){
        LocalDate localDate = LocalDate.of(this.year, monthNum, date);
        DayOfWeek dayOfWeek = DayOfWeek.from(localDate);

        //Check if it is the weekend
        if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) {
            Weekend newWeekend = new Weekend();
            shifts.add(newWeekend);
        }
        //Check if it is a weekday
        else {
            Weekday newWeekday = new Weekday();
            shifts.add(newWeekday);
        }
    }

    /**
     * This method returns the month in numeric form
     * @return the month number
     */
    public int getMonthNum(){
        return this.monthNum;
    }

    /**
     * This method returns this months year
     * @return the year
     */
    public int getYear(){
        return this.year;
    }

    /**
     * This method returns the size of the array list
     * @return the size of the list, representing the number of days
     */
    public int getSize(){
        return n;
    }
}
