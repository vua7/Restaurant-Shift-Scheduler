package com.example.a395_team_ritchie;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import android.content.Context;

@Database(version = 1, entities = {Shifts.class, Student.class, StudentShiftsCrossRef.class})
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    abstract public ShiftsDao getShiftsDao();

    abstract public StudentDao getStudentDao();

    public static AppDatabase instance;

    public static AppDatabase getInstance(final Context context) {

        instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "app-db-1").allowMainThreadQueries().build();
        return instance;
    }

}
