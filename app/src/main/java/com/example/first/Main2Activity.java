package com.example.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    private EditText et_username;
    private EditText et_password;
    private Button btnLogin;
    private Button btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //获得这些组件
        //获得组件
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        //设置button的监听
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_login:
                        String name=et_username.getText().toString();
                        String pwd=et_password.getText().toString();
                        login(name,pwd);
                        break;
                    case R.id.btn_register:
                        register();
                        break;

                }

            }
        });
    }
    private void login(String name, String pwd) {
        if("sgg".equals(name)&&"123456".equals(pwd)){
            Intent intent = new Intent(Main2Activity.this, informationActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"用户名或密码不正确",Toast.LENGTH_SHORT).show();
        }
    }

    private void register() {
    }

}
