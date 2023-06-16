package com.example.students_project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_login = findViewById(R.id.btn_login);
        EditText et_user = findViewById(R.id.et_user);
        EditText et_password = findViewById(R.id.et_password);
        TextView tv_do = findViewById(R.id.tv_do);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_name = et_user.getText().toString();
                String password = et_password.getText().toString();

                if (user_name.length() == 0) {
                    et_user.setError("اسم مستخدم فارغ");
                } else if (user_name.length() < 4) {
                    et_user.setError("يجب أن يكون اسم المستخدم أكثر من 3");
                }

                if (password.length() == 0) {
                    et_user.setError("كلمة المرور فارغة");
                } else if (!TextUtils.isDigitsOnly(password)) {
                    et_user.setError("يجب أن تتكون كلمة المرور من أرقام فقط");
                }

                Intent intent = new Intent(MainActivity.this, Home_Activity.class);
                startActivity(intent);



            }
        });




        tv_do.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Register_Activity.class);
                startActivity(intent);
            }
        });


    }

}