package com.example.a395_team_ritchie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StudentViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view);

        final Button addStudent = (Button) findViewById(R.id.addStudentbutton);
        final LinearLayout layout = (LinearLayout) findViewById(R.id.studentLinear);

        for (int i = 0; i < 50; i++) {
            TextView tv = new TextView(this);
            tv.setText("testing" + i);
            layout.addView(tv);

        }

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addStudentIntent = new Intent(getApplicationContext(), AddStudentActivity.class);
                startActivity(addStudentIntent);
            }
        });
    }
}