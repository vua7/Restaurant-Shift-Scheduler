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

public class AddStudentActivity extends AppCompatActivity {

    public AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        database = AppDatabase.getInstance(this);
        final StudentDao studentDao = database.getStudentDao();

        final Button addStudentButtonFinal = (Button) findViewById(R.id.addStudentButtonFinal);
        addStudentButtonFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent addStudentIntent = new Intent(getApplicationContext(), DayViewActivity.class);
                startActivity(addStudentIntent);*/

                //StudentDao studentDao;
                Student newStudent = new Student();

                EditText editText = findViewById(R.id.studentIDField);
                final int tempNum = Integer.parseInt(editText.getText().toString());
                newStudent.setStudentID(tempNum);

                editText = findViewById(R.id.studentNameField);
                String tempStr = editText.getText().toString();
                newStudent.setStudentName(tempStr);

                editText = findViewById(R.id.studentEmailField);
                tempStr = editText.getText().toString();
                newStudent.setEmail(tempStr);

                Switch tempSwOpen = (Switch) findViewById(R.id.openSwitch);
                Boolean swStateOpen = tempSwOpen.isChecked();

                Switch tempSwClose = (Switch) findViewById(R.id.closeSwitch);
                Boolean swStateClose = tempSwClose.isChecked();

                if (swStateOpen && swStateClose) {
                    newStudent.canOpen();
                    newStudent.canClose();
                } else if (swStateOpen) {
                    newStudent.canOpen();
                } else if (swStateClose) {
                    newStudent.canClose();
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
                        newStudent.setDays(days);
                        newStudent.setTimes((times));
                    }
                    else if(swSwitchMondayPM){
                        days.add("Monday");
                        times.add("afternoon");
                        newStudent.setDays(days);
                        newStudent.setTimes((times));
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
                        newStudent.setDays(days);
                        newStudent.setTimes((times));
                    }
                    else if(swSwitchTuesdayPM){
                        days.add("Tuesday");
                        times.add("afternoon");
                        newStudent.setDays(days);
                        newStudent.setTimes((times));
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
                        newStudent.setDays(days);
                        newStudent.setTimes((times));
                    }
                    else if(swSwitchWednesdayPM){
                        days.add("Wednesday");
                        times.add("afternoon");
                        newStudent.setDays(days);
                        newStudent.setTimes((times));
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
                        newStudent.setDays(days);
                        newStudent.setTimes((times));
                    }
                    else if(swSwitchThursdayPM){
                        days.add("Thursday");
                        times.add("afternoon");
                        newStudent.setDays(days);
                        newStudent.setTimes((times));
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
                        newStudent.setDays(days);
                        newStudent.setTimes((times));
                    }
                    else if(swSwitchFridayPM){
                        days.add("Friday");
                        times.add("afternoon");
                        newStudent.setDays(days);
                        newStudent.setTimes((times));
                    }
                }

                Switch tempSaturdaySwitch = (Switch) findViewById(R.id.saturdaySwitch);
                Boolean swStateSaturday = tempSaturdaySwitch.isChecked();

                if(swStateSaturday){
                    days.add("Saturday");
                    times.add("full day");
                    newStudent.setDays(days);
                    newStudent.setTimes((times));
                }

                Switch tempSundaySwitch = (Switch) findViewById(R.id.sundaySwitch);
                Boolean swStateSunday = tempSundaySwitch.isChecked();

                if(swStateSunday){
                    days.add("Sunday");
                    times.add("full day");
                    newStudent.setDays(days);
                    newStudent.setTimes((times));
                }

                System.out.println("ADD STUDENT****************************");
                System.out.println("Student generated: \n" + newStudent);
                studentDao.insertStudent(newStudent);

                System.out.println("RETRIEVE STUDENT****************************");
                Student getStudent = studentDao.getStudent(tempNum);
                System.out.println("Student after insert/retrieve: \n" + getStudent);

                List<Student> dbStudents = studentDao.getAllStudents();
                System.out.println(dbStudents);

            }
        });
    }
}
