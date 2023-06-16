package com.example.students_project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.students_project_1.datebase.DbHelper;

public class Add_Student_Activity extends AppCompatActivity {

    private EditText dateEditText;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        EditText Fname=findViewById(R.id.et_FName);
        EditText Lname=findViewById(R.id.et_LName);
        Button btn_AddStudent=findViewById(R.id.btn_AddStudent);
        DbHelper dbHelper=new DbHelper(this);


        dateEditText = findViewById(R.id.et_age);
        dateEditText.setFocusable(false);


        btn_AddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fname=Fname.getText().toString();
                String lname=Lname.getText().toString();
                String age=dateEditText.getText().toString();
                boolean isinsert=dbHelper.insertStudents(fname,lname, Integer.parseInt(age));

                if (isinsert){
                    finish();
                } else {
                    Toast.makeText(Add_Student_Activity.this, "Something is wrong", Toast.LENGTH_SHORT).show();
                }


            }
        });




    }
    public void openDatePicker(View view) {
        // Create a DatePickerDialog
        datePickerDialog = new DatePickerDialog(this, (view1, year, month, dayOfMonth) -> {
            // Set the selected date to the EditText
            dateEditText.setText(dayOfMonth + "/" + (month+1) + "/" + year);
        }, 2023, 6, 18); // Set the initial date

        // Show the DatePickerDialog
        datePickerDialog.show();
    }
}