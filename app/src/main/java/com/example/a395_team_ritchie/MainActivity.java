package com.example.a395_team_ritchie;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CalendarView cal = (CalendarView) findViewById(R.id.calendarView);

        Button studentsButton = (Button) findViewById(R.id.studentsButton);
        studentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent studentIntent = new Intent(getApplicationContext(), StudentViewActivity.class);
                startActivity(studentIntent);
            }
        });

        Button dayButton = (Button) findViewById(R.id.dayButton);
        dayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = "Date: " + cal.getDate();
                Intent dayIntent = new Intent(getApplicationContext(), DayViewActivity.class);
                dayIntent.putExtra("DATE", date);
                startActivity(dayIntent);
            }
        });
    }


    /** Called when the user taps the Send Button
    public void sendMessage(View view) {

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);


    } **/


}