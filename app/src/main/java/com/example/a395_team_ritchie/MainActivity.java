package com.example.a395_team_ritchie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    private CalendarView cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cal = (CalendarView) findViewById(R.id.calendarView);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String selectedDate = year + "/" + (month + 1) + "/" + dayOfMonth;

                Intent dayIntent = new Intent(getApplicationContext(), DayViewActivity.class);
                dayIntent.putExtra("DATE", selectedDate);
                startActivity(dayIntent);
            }
        });

        //final CalendarView cal = (CalendarView) findViewById(R.id.calendarView);

        Button studentsButton = (Button) findViewById(R.id.studentsButton);
        studentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent studentIntent = new Intent(getApplicationContext(), StudentViewActivity.class);
                startActivity(studentIntent);
            }
        });

        Button dayButton = (Button) findViewById(R.id.dayButton);



        // ------------------------------------------


        


        dayButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                /*
                SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
                String selectedDate = simpleDate.format(new Date(cal.getDate()));

                //String date = "Date: " + cal.getDate();
                Intent dayIntent = new Intent(getApplicationContext(), DayViewActivity.class);
                //dayIntent.putExtra("DATE", date);
                dayIntent.putExtra("DATE", selectedDate);
                startActivity(dayIntent); */

                Intent scheduleIntent = new Intent(getApplicationContext(), ViewSchedule.class);
                startActivity(scheduleIntent);
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