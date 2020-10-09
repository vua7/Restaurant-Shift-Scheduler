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

import static org.hamcrest.MatcherAssert.assertThat;


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
        /*User user = TestUtil.createUser(3);
        user.setName("george");
        userDao.insert(user);
        List<User> byName = userDao.findUsersByName("george");
        assertThat(byName.get(0), equalTo(user));*/

        Student testPerson = new Student();
        testPerson.setStudentID(1);
        testPerson.setStudentName("Test Student, id=1");

        studentDao.insertStudent(testPerson);

        Student getPerson = studentDao.getStudent(1);

        assert(testPerson.getName().equals(getPerson.getName()));

    }
}

