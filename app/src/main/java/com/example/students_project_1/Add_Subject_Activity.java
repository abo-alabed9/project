package com.example.students_project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.students_project_1.datebase.DbHelper;

public class Add_Subject_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);
        EditText et_add=findViewById(R.id.et_add);
        Button btn_add=findViewById(R.id.btn_add);
        DbHelper dbHelper=new DbHelper(this);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_subject=et_add.getText().toString();

                boolean isinsert=dbHelper.insertSubjects(add_subject);
                if (isinsert){
                    finish();
                } else {
                    Toast.makeText(Add_Subject_Activity.this, "Something is wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}