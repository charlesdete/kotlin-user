package com.example.userlogin;

import  android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import  androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityRegister extends AppCompatActivity {
    EditText etUser, etPwd, etRePwd;
    Button RegisterButton;
    Button Gotologin;
DBHelper dbHelper;

    @Override
    protected  void onCreate (@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        etUser = findViewById(R.id.username);
        etPwd = findViewById(R.id.Password);
        etRePwd = findViewById(R.id.RePassword);
        RegisterButton = findViewById(R.id.RegisterButton);

        dbHelper = new DBHelper(this);
        RegisterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
              String user,pwd,rePwd;
              user = etUser.getText().toString();
              pwd = etPwd.getText().toString();
              rePwd = etRePwd.getText().toString();
              if(user.equals("") || pwd.equals("") || rePwd.equals("")){
                  Toast.makeText(ActivityRegister.this, "Please fill all the fields", Toast.LENGTH_LONG).show();
              } else {
                if(pwd.equals(rePwd)){
                    if(dbHelper.checkUsername(user)){

                        Toast.makeText(ActivityRegister.this, "User Already Exists", Toast.LENGTH_LONG).show();
                    }
                    //proceed with registration
               boolean registeredSuccess = dbHelper.insertData(user, pwd);
                if(registeredSuccess)
                    Toast.makeText(ActivityRegister.this, "User Registered Successfully", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(ActivityRegister.this, "User Registered Failed", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(ActivityRegister.this, "Passwords do not match", Toast.LENGTH_LONG).show();
                }
              }
            }

        });
    }
}
