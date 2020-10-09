package com.example.a395_team_ritchie;

import androidx.room.Entity;

@Entity(primaryKeys = {"id", "date"})
public class StudentShiftsCrossRef {
    public int id;
    public int date;
}
