package com.example.students_project_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.students_project_1.datebase.DbHelper;
import com.example.students_project_1.models.Students;

import java.util.ArrayList;

public class Name_Student_Acyivity extends AppCompatActivity {

    Coustmer_Recycle_Adabter_Name_Student adabter_name_student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_student_acyivity);

        RecyclerView rv_name_student=findViewById(R.id.rv_name_students);

        DbHelper dbHelper=new DbHelper(this);
        ArrayList<Students>data=dbHelper.getAllStudents();

        adabter_name_student=new Coustmer_Recycle_Adabter_Name_Student(this,data);
        rv_name_student.setAdapter(adabter_name_student);

        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv_name_student.setLayoutManager(manager);


    }
}