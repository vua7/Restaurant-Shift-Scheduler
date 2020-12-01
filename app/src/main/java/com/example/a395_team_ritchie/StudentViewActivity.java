package com.example.a395_team_ritchie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class StudentViewActivity extends AppCompatActivity {

    public AppDatabase database;
    private Boolean isCreate = false;
    //private Boolean oneResume = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view);

        isCreate = true;

        final Button addStudent = (Button) findViewById(R.id.addStudentButtonInitial);
        //final Button updateStudent = (Button) findViewById(R.id.updateStudentButtonInitial);
        final LinearLayout layout = (LinearLayout) findViewById(R.id.studentLinear);

        database = AppDatabase.getInstance(this);
        final StudentDao studentDao = database.getStudentDao();

        List<Student> dbStudents = studentDao.getAllStudents();
        //System.out.println(dbStudents);

        /*for (int i = 0; i < dbStudents.size(); i++) {
            TextView tv = new TextView(this);
            tv.setText(dbStudents.get(i).toString());
            layout.addView(tv);
        }*/
        for (int i = 0; i < dbStudents.size(); i++) {
            final int sID = dbStudents.get(i).getID();
            String sName = dbStudents.get(i).getName();

            Button studentBtn = new Button(this);
            //studentBtn.setLayoutParams(new LayoutParams());
            studentBtn.setText(sName);
            studentBtn.setId(sID);

            studentBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent editStudentIntent = new Intent(getApplicationContext(), EditStudentActivity.class);
                    editStudentIntent.putExtra("ID", sID);
                    startActivity(editStudentIntent);
                }
            });

            layout.addView(studentBtn);
        }

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addStudentIntent = new Intent(getApplicationContext(), AddStudentActivity.class);
                startActivity(addStudentIntent);
            }
        });

        /*updateStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent updateStudentIntent= new Intent(getApplicationContext(), EditStudentActivity.class);
                startActivity(updateStudentIntent);
            }
        });*/
    }

    @Override
    public void onStop() {
        super.onStop();
        isCreate = false;

        final LinearLayout layout = (LinearLayout) findViewById(R.id.studentLinear);
        database = AppDatabase.getInstance(this);
        final StudentDao studentDao = database.getStudentDao();
        List<Student> dbStudents = studentDao.getAllStudents();

        for (int i = 0; i < dbStudents.size(); i++) {
            final int sID = dbStudents.get(i).getID();
            String sName = dbStudents.get(i).getName();

            String findID = "R.id." + String.valueOf(sID);
            final Button delButton = (Button) findViewById(sID);

            layout.removeView(delButton);
        }

    }

    @Override
    public void onResume() {
        super.onResume();

        if (!isCreate) {
            //oneResume = true;

            final Button addStudent = (Button) findViewById(R.id.addStudentButtonInitial);
            //final Button updateStudent = (Button) findViewById(R.id.updateStudentButtonInitial);
            final LinearLayout layout = (LinearLayout) findViewById(R.id.studentLinear);

            database = AppDatabase.getInstance(this);
            final StudentDao studentDao = database.getStudentDao();

            List<Student> dbStudents = studentDao.getAllStudents();

            for (int i = 0; i < dbStudents.size(); i++) {
                final int sID = dbStudents.get(i).getID();
                String sName = dbStudents.get(i).getName();

                Button studentBtn = new Button(this);
                studentBtn.setText(sName);
                studentBtn.setId(sID);

                studentBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent editStudentIntent = new Intent(getApplicationContext(), EditStudentActivity.class);
                        editStudentIntent.putExtra("ID", sID);
                        startActivity(editStudentIntent);
                    }
                });

                layout.addView(studentBtn);
            }
        }

    }

}