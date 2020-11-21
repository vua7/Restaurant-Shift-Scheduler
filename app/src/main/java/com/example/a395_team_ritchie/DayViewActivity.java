package com.example.a395_team_ritchie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DayViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_view);

        String inputDate = getIntent().getStringExtra("DATE");

        TextView tv = (TextView) findViewById(R.id.dateText);
        tv.setText(inputDate);
    }
}