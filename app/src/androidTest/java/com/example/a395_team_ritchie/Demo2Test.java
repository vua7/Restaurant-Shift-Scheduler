package com.example.a395_team_ritchie;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;

public class Demo2Test {

    Students testStudents1;
    Weekday testWeekday1;
    Weekend testWeekend1;
    BusyWeekday testBusyWeekday1;
    BusyWeekend testBusyWeekend1;

    @Before
    public void createStudents() {
        testStudents1 = new Students();
        testWeekday1 = new Weekday();
        testWeekend1 = new Weekend();
        testBusyWeekday1 = new BusyWeekday();
        testBusyWeekend1 = new BusyWeekend();

    }

    @After

    @Test
    public void testStudents() {
        testStudents1.addStudent("John Doe", 12345);
        testStudents1.addStudent("Jane Doe", 12345);

        testStudents1.removeStudent("John Doe");
        testStudents1.removeStudent("Jane Doe");

        Students testStudents2 = new Students();
        testStudents2.addStudent("Other Joe", 12345);

        assertFalse (testStudents1 == testStudents2);

        Student testStudent1 = new Student();
        Student testStudent2 = new Student();

        testStudents1.addStudent("John Wick", 12345);
        testStudents1.addStudent("John Rambo", 12345);
        testStudent1 = testStudents1.getStudent("John Wick");
        testStudent2 = testStudents1.getStudent("John Rambo");
        testStudent1.setEmail("test@gmail.com");
        ArrayList<Integer> dates = new ArrayList<>();
        dates.add(1);
        dates.add(2);
        dates.add(3);
        dates.add(4);
        dates.add(5);
        testStudent1.setDates(dates);

        Student otherStudent1 = new Student();
        otherStudent1.setStudentName("Bill");
        otherStudent1.setStudentID(12345);
        otherStudent1.canOpen();

        Student otherStudent2 = new Student();
        otherStudent2.setStudentName("Bob");
        otherStudent2.setStudentID(67890);
        otherStudent2.canClose();

        System.out.println("--------------ADAPTABLE MONTH LIST------------------");
        Month month = new Month("january", 2011);
        month.addStudentToShift(testStudent1, 1, "fullday");
        month.addStudentToShift(testStudent2, 2, "fullday");
        assert(month.getSize() == 31);
        month.printShifts();

        System.out.println("---------------EDIT STUDENT----------------");
        assert(testStudent1.getEmail().equals("test@gmail.com"));
        System.out.println(testStudent1);

        System.out.println("--------------------------------");
        testStudent1.setEmail("newEamil@gmail.com");
        assert(testStudent1.getEmail().equals("newEamil@gmail.com"));
        System.out.println(testStudent1);


    }

}
