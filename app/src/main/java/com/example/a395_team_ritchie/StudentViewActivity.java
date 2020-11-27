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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view);

        final Button addStudent = (Button) findViewById(R.id.addStudentButtonInitial);
        final Button updateStudent = (Button) findViewById(R.id.updateStudentButtonInitial);
        final LinearLayout layout = (LinearLayout) findViewById(R.id.studentLinear);

        /*for (int i = 0; i < 50; i++) {
            TextView tv = new TextView(this);
            tv.setText("testing" + i);
            layout.addView(tv);
        }*/

        database = AppDatabase.getInstance(this);
        final StudentDao studentDao = database.getStudentDao();

        List<Student> dbStudents = studentDao.getAllStudents();
        System.out.println(dbStudents);

        for (int i = 0; i < dbStudents.size(); i++) {
            TextView tv = new TextView(this);
            tv.setText(dbStudents.get(i).toString());
            layout.addView(tv);
        }

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addStudentIntent = new Intent(getApplicationContext(), AddStudentActivity.class);
                startActivity(addStudentIntent);
            }
        });

        updateStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent updateStudentIntent= new Intent(getApplicationContext(), EditStudentActivity.class);
                startActivity(updateStudentIntent);
            }

        });
    }
}