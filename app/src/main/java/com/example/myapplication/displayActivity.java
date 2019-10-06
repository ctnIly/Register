package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class displayActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");
        final String password = intent.getStringExtra("password");
        final String sex = intent.getStringExtra("sex");
        String sh = new String();
        sh = "用户名：" + name + "\n" + "密码：" + password + "\n" + "性别：" + sex;
        textView = findViewById(R.id.tv9);
        final String finalSh = sh;
        textView.setText(sh);
    }
}
