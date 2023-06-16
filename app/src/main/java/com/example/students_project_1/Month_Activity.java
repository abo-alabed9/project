package com.example.students_project_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Month_Activity extends AppCompatActivity {
Coustomeer_Recycle_Adabter_Month adabter_month;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month);

        RecyclerView rv_month=findViewById(R.id.rv_month);


        ArrayList<Month> data = new ArrayList<>();

        Month month1 = new Month();
        month1.setName("يناير");
        data.add(month1);

        Month month2 = new Month();
        month2.setName("فبرايد");
        data.add(month2);

        Month month3 = new Month();
        month3.setName("مارس");
        data.add(month3);

        Month month4 = new Month();
        month4.setName("ابريل");
        data.add(month4);

        Month month5 = new Month();
        month5.setName("مايو");
        data.add(month5);

        Month month6 = new Month();
        month6.setName("يونيو");
        data.add(month6);

        Month month7 = new Month();
        month7.setName("يوليو");
        data.add(month7);

        Month month8 = new Month();
        month8.setName("اغسطس");
        data.add(month8);

        Month month9 = new Month();
        month9.setName("سبتمبر");
        data.add(month9);

        Month month10 = new Month();
        month10.setName("اكتوبر");
        data.add(month10);

        Month month11 = new Month();
        month11.setName("نوفمبر");
        data.add(month11);

        Month month12 = new Month();
        month12.setName("ديسمبر");
        data.add(month12);

        adabter_month=new Coustomeer_Recycle_Adabter_Month(this, data, new Coustomeer_Recycle_Adabter_Month.onItemClickListener() {
            @Override
            public void onClick(Month month, int position) {
                Intent intent=new Intent(Month_Activity.this,Months_Activity.class);
                startActivity(intent);

            }
        });
        rv_month.setAdapter(adabter_month);

        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv_month.setLayoutManager(manager);








    }
}