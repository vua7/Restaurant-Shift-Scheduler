package com.example.a395_team_ritchie;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;

//aka Shifts with Students
public class Schedule {
    @Embedded public Shifts shift;
    @Relation(
            parentColumn = "date",
            entityColumn = "id",
            associateBy = @Junction(StudentShiftsCrossRef.class)
    )
    public List<Student> shiftList;

}
