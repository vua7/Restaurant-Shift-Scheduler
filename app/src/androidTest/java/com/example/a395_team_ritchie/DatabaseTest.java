package com.example.a395_team_ritchie;

import android.content.Context;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;
import java.io.IOException;
import java.util.List;

//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class DatabaseTest {
    //private ShiftsDao shiftsDao;
    private StudentDao studentDao;
    private AppDatabase db;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).allowMainThreadQueries().build();
        //shiftsDao = db.getShiftsDao();
        studentDao = db.getStudentDao();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void writeUserAndReadInList() throws Exception {
        Student testPerson = new Student();
        testPerson.setStudentID(1);
        testPerson.setStudentName("Test Student, id=1");

        studentDao.insertStudent(testPerson);
        Student getPerson = studentDao.getStudent(1);
        assert(testPerson.getName().equals(getPerson.getName()));

        Student testPerson2 = new Student();
        testPerson2.setStudentID(2);
        testPerson2.setStudentName("Test Student2, id=2");

        System.out.println("test1. " + testPerson.getName());
        System.out.println("test2. " + testPerson2.getName());

        studentDao.insertStudent(testPerson2);
        Student getPerson2 = studentDao.getStudent(2);

        assert(testPerson2.getName().equals(getPerson2.getName()));
        assertFalse(testPerson2.getName().equals(getPerson.getName())) ;

        System.out.println("get1. " + getPerson.getName());
        System.out.println("get2. " + getPerson2.getName());

        assertEquals(testPerson2.getName(), getPerson2.getName());

        studentDao.deleteStudent(testPerson);
        studentDao.deleteStudent(testPerson2);

    }
}

