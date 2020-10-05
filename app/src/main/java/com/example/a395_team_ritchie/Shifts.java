package com.example.a395_team_ritchie;

/**
 * This is the Shifts interface. The methods included are shared between the multiple types of
 * shifts: weekday, weekend, busy weekday, busy weekend.
 */
public interface Shifts {
    //Methods
    public void fillShift(Student student, String timeOfDay);
    public boolean isDayFull();
    public void clearShift(String studentName);
    public boolean morningShiftFull();
    public boolean afternoonShiftFull();
}
