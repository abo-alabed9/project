package com.example.students_project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.students_project_1.datebase.DbHelper;

public class Register_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btn_Create=findViewById(R.id.btn_Create);
        EditText et_user_name2=findViewById(R.id.et_user_name2);
        EditText et_password2=findViewById(R.id.et_password2);
        EditText et_Email2=findViewById(R.id.et_Email2);
        DbHelper dbHelper=new DbHelper(this);


        btn_Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_name = et_user_name2.getText().toString();
                String password = et_password2.getText().toString();
                String email = et_Email2.getText().toString();
                boolean isinsert=dbHelper.insertAdmin(user_name,email,password);
                if (isinsert){
                    finish();
                } else {
                    Toast.makeText(Register_Activity.this, "Something is wrong", Toast.LENGTH_SHORT).show();
                }

                if (user_name.length() == 0) {
                    et_user_name2.setError("اسم مستخدم فارغ");
                } else if (user_name.length() < 4) {
                    et_user_name2.setError("يجب أن يكون اسم المستخدم أكثر من 3");
                }

                if (password.length() == 0) {
                    et_password2.setError("كلمة المرور فارغة");
                } else if (!TextUtils.isDigitsOnly(password)) {
                    et_password2.setError("يجب أن تتكون كلمة المرور من أرقام فقط");
                }
                if (email.length()==0){
                    et_Email2.setError("بريد إلكتروني فارغ");
                }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    et_Email2.setError("بريد إلكتروني خاطئ");

                }

                Intent intent =new Intent(Register_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}