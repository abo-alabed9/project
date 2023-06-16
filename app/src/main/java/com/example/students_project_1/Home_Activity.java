package com.example.students_project_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity {
    Customer_Recycle_Adabter_Home adabterHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView tv_add_subject=findViewById(R.id.tv_add_subject);
        TextView tv_=findViewById(R.id.tv_);
        TextView tv_add_Student=findViewById(R.id.tv_add_Student);
        ImageView img_add_Subject=findViewById(R.id.img_add_Subject);
        ImageView img_add_Student=findViewById(R.id.img_add_Student);
        Button btn_All_Student=findViewById(R.id.btn_All_Student);







        RecyclerView rv_home = findViewById(R.id.rv_home);


        ArrayList<Home> data = new ArrayList<>();

        data.add(new Home(R.drawable.ic_twotone_delete_outline_24, "قواعد بيانات"));
        data.add(new Home(R.drawable.ic_twotone_delete_outline_24, "جافا"));
        data.add(new Home(R.drawable.ic_twotone_delete_outline_24, "ورش اندرويد"));
        data.add(new Home(R.drawable.ic_twotone_delete_outline_24, "تطوير اندرويد"));
        data.add(new Home(R.drawable.ic_twotone_delete_outline_24, "هندسة برمجيات"));
        data.add(new Home(R.drawable.ic_twotone_delete_outline_24, "ريادة اعمال"));

         adabterHome = new Customer_Recycle_Adabter_Home(this, data, new Customer_Recycle_Adabter_Home.onItemClickListener() {
            @Override
            public void onClick(Home home, int position) {
                Intent intent = new Intent(Home_Activity.this, Month_Activity.class);
                startActivity(intent);

            }

            @Override
            public void onDeleteClick(int position) {
//                onBackPressed();

                data.remove(position);
                adabterHome.notifyItemRemoved(position);


            }
        });
        rv_home.setAdapter(adabterHome);

        GridLayoutManager manager = new GridLayoutManager(this, 2);
        rv_home.setLayoutManager(manager);

        img_add_Subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home_Activity.this,Add_Subject_Activity.class);
                startActivity(intent);
            }
        });

        tv_add_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home_Activity.this,Add_Subject_Activity.class);
                startActivity(intent);
            }
        });
        tv_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home_Activity.this,Edit_User_Activity.class);
                startActivity(intent);
            }
        });

        tv_add_Student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home_Activity.this,Add_Student_Activity.class);
                startActivity(intent);
            }
        });

        img_add_Student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home_Activity.this,Add_Student_Activity.class);
                startActivity(intent);
            }
        });

        btn_All_Student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home_Activity.this,All_Student_Activity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Home_Activity.this);
        builder.setTitle("حذف المادة");
        builder.setMessage("هل تريد حذف المادة؟");
        builder.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("لا", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setCancelable(false);
        builder.show();

    }
}