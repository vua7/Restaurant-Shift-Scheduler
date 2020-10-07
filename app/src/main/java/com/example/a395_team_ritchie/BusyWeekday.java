package com.example.a395_team_ritchie;

/**
 * This is the BusyWeekday class. It inherits the methods from the Weekday class, however, it changes
 * the size of the arrays to account for more students working.
 */
public class BusyWeekday extends Weekday{
    //Constructor
    BusyWeekday(){
        super.n = 3;
    }

}
