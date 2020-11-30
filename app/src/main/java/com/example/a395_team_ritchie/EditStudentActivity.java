package com.example.a395_team_ritchie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class EditStudentActivity extends AppCompatActivity {

    public AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        int inputID = getIntent().getIntExtra("ID", 0);

        database = AppDatabase.getInstance(this);
        final StudentDao studentDao = database.getStudentDao();
        final Student editStudent = studentDao.getStudent(inputID);

        EditText editStudentIDText = findViewById(R.id.editStudentIDField);
        EditText editStudentNameText = findViewById(R.id.editStudentNameField);
        EditText editStudentEmailText = findViewById(R.id.editStudentEmailField);

        editStudentIDText.setText(Integer.toString(editStudent.getID()));
        editStudentNameText.setText(editStudent.getName());
        editStudentEmailText.setText(editStudent.getEmail());

        Switch editOpenSwitch = findViewById(R.id.editOpenSwitch);
        Switch editCloseSwitch = findViewById(R.id.editCloseSwitch);

        Switch editMondaySwitch = findViewById(R.id.editMondaySwitch);
        Switch editMondayAMSwitch = findViewById(R.id.editMondayAMSwitch);
        Switch editMondayPMSwitch = findViewById(R.id.editMondayPMSwitch);

        Switch editTuesdaySwitch = findViewById(R.id.editTuesdaySwitch);
        Switch editTuesdayAMSwitch = findViewById(R.id.editTuesdayAMSwitch);
        Switch editTuesdayPMSwitch = findViewById(R.id.editTuesdayPMSwitch);
        
        Switch editWednesdaySwitch = findViewById(R.id.editWednesdaySwitch);
        Switch editWednesdayAMSwitch = findViewById(R.id.editWednesdayAMSwitch);
        Switch editWednesdayPMSwitch = findViewById(R.id.editWednesdayPMSwitch);

        Switch editThursdaySwitch = findViewById(R.id.editThursdaySwitch);
        Switch editThursdayAMSwitch = findViewById(R.id.editThursdayAMSwitch);
        Switch editThursdayPMSwitch = findViewById(R.id.editThursdayPMSwitch);

        Switch editFridaySwitch = findViewById(R.id.editFridaySwitch);
        Switch editFridayAMSwitch = findViewById(R.id.editFridayAMSwitch);
        Switch editFridayPMSwitch = findViewById(R.id.editFridayPMSwitch);

        Switch editSaturdaySwitch = findViewById(R.id.editSaturdaySwitch);
        Switch editSundaySwitch = findViewById(R.id.EditSundaySwitch);

        editOpenSwitch.setChecked(editStudent.canStudentOpen());
        editCloseSwitch.setChecked(editStudent.canStudentClose());

        System.out.println(editStudent.days);
        System.out.println(editStudent.times);
        //[Monday, Tuesday, Wednesday, Thursday, Friday]
        //[morning, afternoon, afternoon, afternoon, afternoon]

        List<String> days = editStudent.getDays();
        List<String> times = editStudent.getTimes();
        //Monday
        Boolean mon = days.contains("Monday");
        int monIndex = days.indexOf("Monday");
        if (mon) {
            Boolean monTime = times.get(monIndex).equals("morning") ? true : false;
            editMondaySwitch.setChecked(true);
            editMondayAMSwitch.setChecked(monTime);
            editMondayPMSwitch.setChecked(!monTime);
        }
        //Tuesday
        Boolean tues = days.contains("Tuesday");
        int tuesIndex = days.indexOf("Tuesday");
        if (tues) {
            Boolean tuesTime = times.get(tuesIndex).equals("morning") ? true : false;
            editTuesdaySwitch.setChecked(true);
            editTuesdayAMSwitch.setChecked(tuesTime);
            editTuesdayPMSwitch.setChecked(!tuesTime);
        }
        //Wednesday
        Boolean wed = days.contains("Wednesday");
        int wedIndex = days.indexOf("Wednesday");
        if (wed) {
            Boolean wedTime = times.get(wedIndex).equals("morning") ? true : false;
            editWednesdaySwitch.setChecked(true);
            editWednesdayAMSwitch.setChecked(wedTime);
            editWednesdayPMSwitch.setChecked(!wedTime);
        }
        //Thursday
        Boolean thurs = days.contains("Thursday");
        int thursIndex = days.indexOf("Thursday");
        if (thurs) {
            Boolean thursTime = times.get(thursIndex).equals("morning") ? true : false;
            editThursdaySwitch.setChecked(true);
            editThursdayAMSwitch.setChecked(thursTime);
            editThursdayPMSwitch.setChecked(!thursTime);
        }
        //Friday
        Boolean fri = days.contains("Friday");
        int friIndex = days.indexOf("Friday");
        if (fri) {
            Boolean friTime = times.get(friIndex).equals("morning") ? true : false;
            editFridaySwitch.setChecked(fri);
            editFridayAMSwitch.setChecked(friTime);
            editFridayPMSwitch.setChecked(!friTime);
        }
        //Saturday
        Boolean sat = days.contains("Saturday");
        editSaturdaySwitch.setChecked(sat);
        //Sunday
        Boolean sun = days.contains("Sunday");
        editSundaySwitch.setChecked(sun);

        Button updateStudent = (Button) findViewById(R.id.editStudentButtonFinal);
        updateStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.studentIDField);
                final int tempNum = Integer.parseInt(editText.getText().toString());
                editStudent.setStudentID(tempNum);

                editText = findViewById(R.id.studentNameField);
                String tempStr = editText.getText().toString();
                editStudent.setStudentName(tempStr);

                editText = findViewById(R.id.studentEmailField);
                tempStr = editText.getText().toString();
                editStudent.setEmail(tempStr);

                Switch tempSwOpen = (Switch) findViewById(R.id.openSwitch);
                Boolean swStateOpen = tempSwOpen.isChecked();

                Switch tempSwClose = (Switch) findViewById(R.id.closeSwitch);
                Boolean swStateClose = tempSwClose.isChecked();

                if (swStateOpen && swStateClose) {
                    editStudent.canOpen();
                    editStudent.canClose();
                } else if (swStateOpen) {
                    editStudent.canOpen();
                } else if (swStateClose) {
                    editStudent.canClose();
                }

                ArrayList<String> days = new ArrayList<>();
                ArrayList<String> times = new ArrayList<>();

                Switch tempMondaySwitch = (Switch) findViewById(R.id.mondaySwitch2);
                Boolean swStateMonday = tempMondaySwitch.isChecked();
                Switch tempMondayAMSwitch = (Switch) findViewById(R.id.mondayAMSwitch);
                Boolean swSwitchMondayAM = tempMondayAMSwitch.isChecked();
                Switch tempMondayPMSwitch = (Switch) findViewById(R.id.mondayPMSwitch);
                Boolean swSwitchMondayPM = tempMondayPMSwitch.isChecked();

                if(swStateMonday){
                    if((swSwitchMondayAM && swSwitchMondayPM) || (!swSwitchMondayAM && !swSwitchMondayPM)){}
                    else if(swSwitchMondayAM){
                        days.add("Monday");
                        times.add("morning");
                        editStudent.setDays(days);
                        editStudent.setTimes((times));
                    }
                    else if(swSwitchMondayPM){
                        days.add("Monday");
                        times.add("afternoon");
                        editStudent.setDays(days);
                        editStudent.setTimes((times));
                    }
                }

                Switch tempTuesdaySwitch = (Switch) findViewById(R.id.tuesdaySwitch);
                Boolean swStateTuesday = tempTuesdaySwitch.isChecked();
                Switch tempTuesdayAMSwitch = (Switch) findViewById(R.id.tuesdayAMSwitch);
                Boolean swSwitchTuesdayAM = tempTuesdayAMSwitch.isChecked();
                Switch tempTuesdayPMSwitch = (Switch) findViewById(R.id.tudesdayPMSwitch);
                Boolean swSwitchTuesdayPM = tempTuesdayPMSwitch.isChecked();

                if(swStateTuesday){
                    if((swSwitchTuesdayAM && swSwitchTuesdayPM) || (!swSwitchTuesdayAM && !swSwitchTuesdayPM)){}
                    else if(swSwitchTuesdayAM){
                        days.add("Tuesday");
                        times.add("morning");
                        editStudent.setDays(days);
                        editStudent.setTimes((times));
                    }
                    else if(swSwitchTuesdayPM){
                        days.add("Tuesday");
                        times.add("afternoon");
                        editStudent.setDays(days);
                        editStudent.setTimes((times));
                    }
                }

                Switch tempWednesdaySwitch = (Switch) findViewById(R.id.wednesdaySwitch);
                Boolean swStateWednesday = tempWednesdaySwitch.isChecked();
                Switch tempWednesdayAMSwitch = (Switch) findViewById(R.id.wednesdayAMSwitch);
                Boolean swSwitchWednesdayAM = tempWednesdayAMSwitch.isChecked();
                Switch tempWednesdayPMSwitch = (Switch) findViewById(R.id.wednesdayPMSwitch);
                Boolean swSwitchWednesdayPM = tempWednesdayPMSwitch.isChecked();

                if(swStateWednesday){
                    if((swSwitchWednesdayAM && swSwitchWednesdayPM) || (!swSwitchWednesdayAM && !swSwitchWednesdayPM)){}
                    else if(swSwitchWednesdayAM){
                        days.add("Wednesday");
                        times.add("morning");
                        editStudent.setDays(days);
                        editStudent.setTimes((times));
                    }
                    else if(swSwitchWednesdayPM){
                        days.add("Wednesday");
                        times.add("afternoon");
                        editStudent.setDays(days);
                        editStudent.setTimes((times));
                    }
                }

                Switch tempThursdaySwitch = (Switch) findViewById(R.id.thursdaySwitch);
                Boolean swStateThursday = tempThursdaySwitch.isChecked();
                Switch tempThursdayAMSwitch = (Switch) findViewById(R.id.thursdayAMSwitch);
                Boolean swSwitchThursdayAM = tempThursdayAMSwitch.isChecked();
                Switch tempThursdayPMSwitch = (Switch) findViewById(R.id.thursdayPMSwitch);
                Boolean swSwitchThursdayPM = tempThursdayPMSwitch.isChecked();

                if(swStateThursday){
                    if((swSwitchThursdayAM && swSwitchThursdayPM) || (!swSwitchThursdayAM && !swSwitchThursdayPM)){}
                    else if(swSwitchThursdayAM){
                        days.add("Thursday");
                        times.add("morning");
                        editStudent.setDays(days);
                        editStudent.setTimes((times));
                    }
                    else if(swSwitchThursdayPM){
                        days.add("Thursday");
                        times.add("afternoon");
                        editStudent.setDays(days);
                        editStudent.setTimes((times));
                    }
                }

                Switch tempFridaySwitch = (Switch) findViewById(R.id.fridaySwitch);
                Boolean swStateFriday = tempFridaySwitch.isChecked();
                Switch tempFridayAMSwitch = (Switch) findViewById(R.id.fridayAMSwitch);
                Boolean swSwitchFridayAM = tempFridayAMSwitch.isChecked();
                Switch tempFridayPMSwitch = (Switch) findViewById(R.id.fridayPMSwitch);
                Boolean swSwitchFridayPM = tempFridayPMSwitch.isChecked();

                if(swStateFriday){
                    if((swSwitchFridayAM && swSwitchFridayPM) || (!swSwitchFridayAM && !swSwitchFridayPM)){}
                    else if(swSwitchFridayAM){
                        days.add("Friday");
                        times.add("morning");
                        editStudent.setDays(days);
                        editStudent.setTimes((times));
                    }
                    else if(swSwitchFridayPM){
                        days.add("Friday");
                        times.add("afternoon");
                        editStudent.setDays(days);
                        editStudent.setTimes((times));
                    }
                }

                Switch tempSaturdaySwitch = (Switch) findViewById(R.id.saturdaySwitch);
                Boolean swStateSaturday = tempSaturdaySwitch.isChecked();

                if(swStateSaturday){
                    days.add("Saturday");
                    times.add("full day");
                    editStudent.setDays(days);
                    editStudent.setTimes((times));
                }

                Switch tempSundaySwitch = (Switch) findViewById(R.id.sundaySwitch);
                Boolean swStateSunday = tempSundaySwitch.isChecked();

                if(swStateSunday){
                    days.add("Sunday");
                    times.add("full day");
                    editStudent.setDays(days);
                    editStudent.setTimes((times));
                }

                studentDao.updateStudent(editStudent);
                
                Intent studentViewIntent = new Intent(getApplicationContext(), StudentViewActivity.class);
                startActivity(studentViewIntent);
            }
        });

        Button removeStudent = (Button) findViewById(R.id.removeStudentButtonFinal);
        removeStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentDao.deleteStudent(editStudent);
                Intent studentViewIntent = new Intent(getApplicationContext(), StudentViewActivity.class);
                startActivity(studentViewIntent);
            }
        });
    }
}