package com.example.students_project_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class Months_Activity extends AppCompatActivity {
    CustomRecycleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months);
        RecyclerView rv_months = findViewById(R.id.rv_months);

        ArrayList<Months> data = new ArrayList<>();


        data.add(new Months("1"));
        data.add(new Months("2"));
        data.add(new Months("3"));
        data.add(new Months("4"));
        data.add(new Months("5"));
        data.add(new Months("6"));
        data.add(new Months("7"));
        data.add(new Months("8"));
        data.add(new Months("9"));
        data.add(new Months("10"));
        data.add(new Months("11"));
        data.add(new Months("12"));
        data.add(new Months("13"));
        data.add(new Months("14"));
        data.add(new Months("15"));
        data.add(new Months("16"));
        data.add(new Months("17"));
        data.add(new Months("18"));
        data.add(new Months("19"));
        data.add(new Months("20"));
        data.add(new Months("21"));
        data.add(new Months("22"));
        data.add(new Months("23"));
        data.add(new Months("24"));
        data.add(new Months("25"));
        data.add(new Months("26"));
        data.add(new Months("27"));
        data.add(new Months("28"));
        data.add(new Months("29"));
        data.add(new Months("30"));






        adapter=new CustomRecycleAdapter(this, data, new CustomRecycleAdapter.onItemClickListener() {
            @Override
            public void onClick(int months, int position) {
                Intent intent=new Intent(Months_Activity.this,Name_Student_Acyivity.class);
                startActivity(intent);
            }
        });





        rv_months.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this, 5);
        rv_months.setLayoutManager(manager);


    }
}