package com.example.a395_team_ritchie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DayViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_view);

        String inputDate = getIntent().getStringExtra("DATE");

        TextView tv = (TextView) findViewById(R.id.dateText);
        tv.setText(inputDate);

        Button scheduleStudentButton = (Button) findViewById(R.id.scheduleStudentButton);
        scheduleStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent studentIntent = new Intent(getApplicationContext(), ScheduleStudentActivity.class);
                startActivity(studentIntent);
            }
        });
    }
}