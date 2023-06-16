package com.example.students_project_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.students_project_1.datebase.DbHelper;
import com.example.students_project_1.models.Students;

import java.util.ArrayList;

public class Details_Student_Activity extends AppCompatActivity {
Customer_Rrcycle_Adabter_Details adabter_details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_student);

        DbHelper dbHelper=new DbHelper(this);

        RecyclerView RV_Detials=findViewById(R.id.RV_Detils);
        ArrayList<Detials>data=new ArrayList<>();
        adabter_details=new Customer_Rrcycle_Adabter_Details(this,data);
        RV_Detials.setAdapter(adabter_details);





        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        RV_Detials.setLayoutManager(manager);

    }
}