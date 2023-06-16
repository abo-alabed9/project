package com.example.students_project_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.students_project_1.datebase.DbHelper;
import com.example.students_project_1.models.Students;

import java.util.ArrayList;

public class All_Student_Activity extends AppCompatActivity {

    Coustmer_Recycle_Adabter_all_Student adabter_all_student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_student);

        RecyclerView rv_all_student=findViewById(R.id.rv_all_student);
        DbHelper dbHelper=new DbHelper(this);
        ArrayList<Students>data=dbHelper.getAllStudents();

        adabter_all_student=new Coustmer_Recycle_Adabter_all_Student(this, data, new Coustmer_Recycle_Adabter_all_Student.onItemClickListener() {
            @Override
            public void onClick(int students, int position) {


            }

            @Override
            public void onDeleteClick(int position) {
                data.remove(position);
                adabter_all_student.notifyItemRemoved(position);
            }
        });
        rv_all_student.setAdapter(adabter_all_student);

        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv_all_student.setLayoutManager(manager);



    }
}