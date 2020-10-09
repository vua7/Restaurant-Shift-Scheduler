package com.example.a395_team_ritchie;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface StudentDao {
    @Query("SELECT * FROM student")
    List<Student> getAllStudents();

    @Query("SELECT * FROM student WHERE id = :id")
    Student getStudent(int id);

    //@Insert(onConflict = OnConflictStrategy.REPLACE)
    @Insert
    void insertStudent(Student student);

    @Update
    void updateStudent(Student student);

    @Delete
    void deleteStudent(Student... student);

}
