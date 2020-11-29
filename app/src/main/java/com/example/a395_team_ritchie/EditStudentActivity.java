package com.example.a395_team_ritchie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class EditStudentActivity extends AppCompatActivity {

    public AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        int inputID = getIntent().getIntExtra("ID", 0);

        database = AppDatabase.getInstance(this);
        final StudentDao studentDao = database.getStudentDao();

        Student editStudent = studentDao.getStudent(inputID);
        System.out.println(inputID);
        System.out.println(editStudent);

        EditText editStudentIDText = findViewById(R.id.editStudentIDField);
        EditText editStudentNameText = findViewById(R.id.editStudentNameField);
        EditText editStudentEmailText = findViewById(R.id.editStudentEmailField);

        editStudentIDText.setText(Integer.toString(editStudent.getID()));
        editStudentNameText.setText(editStudent.getName());
        editStudentEmailText.setText(editStudent.getEmail());

    }
}