package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt1;
    private Button bt2;
    private EditText et1;
    private EditText et2;
    private man Man;
    int n=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         bt1 = findViewById(R.id.button1);
         bt2=findViewById(R.id.button2);
         et1=findViewById(R.id.et1);
         et2=findViewById(R.id.et2);
         bt1.setOnClickListener(this);
         bt2.setOnClickListener(this);
         Man=new man (this,"register_man.db",null,n);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1: {
                String name=et1.getText().toString();
                String password=et2.getText().toString();
                SQLiteDatabase db=Man.getWritableDatabase();
                Cursor cursor=db.query("Man",null,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do {
                        String name1=cursor.getString(cursor.getColumnIndex("name"));
                        Log.d("MainActivity","name is"+name1);
                        String password1=cursor.getString(cursor.getColumnIndex("password"));
                        Log.d("MainActivity","password is"+password1);
                        String sex=cursor.getString(cursor.getColumnIndex("sex"));
                        Log.d("MainActivity","sex is"+sex);
                        if(name.equals(name1)&&password.equals(password1)){
                            Intent intent=new Intent(MainActivity.this,displayActivity.class);
                            intent.putExtra("name",name1);
                            intent.putExtra("password",password1);
                            intent.putExtra("sex",sex);
                            startActivity(intent);
                        }
                    }while (cursor.moveToNext());
                }
                break;
            }
            case R.id.button2:{
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                intent.putExtra("number",n);
                startActivity(intent);
            }

        }


    }
}
