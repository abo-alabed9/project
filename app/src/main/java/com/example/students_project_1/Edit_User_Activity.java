package com.example.students_project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;

public class Edit_User_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        Button btn_Create=findViewById(R.id.btn_Account);
        EditText et_user1=findViewById(R.id.et_user1);
        EditText et_password1=findViewById(R.id.et_password1);
        EditText et_Email1=findViewById(R.id.et_Email1);

        String user_name = et_user1.getText().toString();
        String password = et_password1.getText().toString();
        String email = et_Email1.getText().toString();
        if (user_name.length() == 0) {
            et_user1.setError("اسم مستخدم فارغ");
        } else if (user_name.length() < 4) {
            et_user1.setError("يجب أن يكون اسم المستخدم أكثر من 3");
        }

        if (password.length() == 0) {
            et_password1.setError("كلمة المرور فارغة");
        } else if (!TextUtils.isDigitsOnly(password)) {
            et_password1.setError("يجب أن تتكون كلمة المرور من أرقام فقط");
        }
        if (email.length()==0){
            et_Email1.setError("بريد إلكتروني فارغ");
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            et_Email1.setError("بريد إلكتروني خاطئ");

        }

//        Intent intent =new Intent(Edit_User_Activity.this,Home_Activity.class);
//        startActivity(intent);

    }
}