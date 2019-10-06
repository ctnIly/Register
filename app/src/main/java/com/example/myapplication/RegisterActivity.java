package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStoreOwner;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private Button bt3;
    private Button bt4;
    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private  man Man;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
        et4=findViewById(R.id.et4);
        bt3=findViewById(R.id.button3);
        bt4=findViewById(R.id.button4);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        Man=new man(this,"register_man.db",null,1);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=et1.getText().toString();
                String password1=et2.getText().toString();
                String password2=et3.getText().toString();
                String sex=et4.getText().toString();
                if(name.equals("")){
                    Toast.makeText(RegisterActivity.this,"用户名不能为空！",Toast.LENGTH_SHORT).show();
                    return;
                }else if(password1.equals("")){
                    Toast.makeText(RegisterActivity.this,"密码不能为空！",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(!password2.equals(password1)){
                    Toast.makeText(RegisterActivity.this,"密码确认错误！",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (sex.equals("")){
                    Toast.makeText(RegisterActivity.this,"性别不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    SQLiteDatabase db = Man.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put("name", name);
                    values.put("password", password1);
                    values.put("sex", sex);
                    db.insert("Man", null, values);
                    values.clear();
                    Toast.makeText(RegisterActivity.this, "注册成功！请点击返回键进行再次登录", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
