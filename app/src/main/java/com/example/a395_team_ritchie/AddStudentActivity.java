package com.example.a395_team_ritchie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);


        final Button addStudentButtonFinal = (Button) findViewById(R.id.addStudentButtonFinal);
        addStudentButtonFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent addStudentIntent = new Intent(getApplicationContext(), DayViewActivity.class);
                startActivity(addStudentIntent);*/

                //StudentDao studentDao;
                Student newStudent = new Student();

                EditText editText = findViewById(R.id.studentIDField);
                int tempNum = Integer.parseInt(editText.getText().toString());
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



                System.out.println(newStudent);
            }
        });

    }




}