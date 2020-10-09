package com.example.a395_team_ritchie;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * This is the Shifts superclass. The methods included are inherited by the multiple types of
 * shifts: weekday, weekend.
 */
@Entity(tableName = "shift")
abstract class Shifts {
    //Instance Vars
    @PrimaryKey
    public int date;

    @ColumnInfo(name = "isBusy")
    public boolean isBusy;

    @ColumnInfo(name = "type")
    public String type;

    //Methods
    public abstract void fillShift(Student student, String timeOfDay);
    public abstract boolean isDayFull();
    public abstract void clearShift(String studentName);
}