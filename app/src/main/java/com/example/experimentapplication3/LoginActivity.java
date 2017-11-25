package com.example.experimentapplication3;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    private Button login_bt;
    private Button register_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //隐藏自带的标题栏
//        ActionBar actionBar = getSupportActionBar();
//        if( actionBar != null){
//            actionBar.hide();
//        }

        Bmob.initialize(LoginActivity.this,"467ad218dcc360db6a38d4224d6072af");

        login_bt = (Button) findViewById(R.id.login_button);
        register_bt = (Button) findViewById(R.id.register_button);
        register_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterActivity.ActionStart(LoginActivity.this);
            }
        });
        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击登录按钮
                username = (EditText) findViewById(R.id.username);
                password = (EditText) findViewById(R.id.password);

                Users user = new Users();
                user.setUsername(username.getText().toString());
                user.setPassword(password.getText().toString());
                user.login(new SaveListener<Users>() {

                    @Override
                    public void done(Users users, BmobException e) {
                        if(e == null) {
                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            Features.actionStart(LoginActivity.this);
                        }
                        else
                            Toast.makeText(LoginActivity.this,"登录失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
