package com.example.a395_team_ritchie;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ShiftsDao {
    @Query("SELECT * FROM shift")
    List<Shifts> getAllShifts();

    @Query("SELECT * FROM shift WHERE date BETWEEN :from AND :to")
    List<Shifts> getShifts(int from, int to);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertShift(Shifts shift);

    @Update
    void updateShift(Shifts shift);

    @Delete
    void deleteShift(Shifts... shift);

    @Transaction
    @Query("SELECT * FROM shift")
    public List<Schedule> getSchedule();
}
