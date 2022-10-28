package com.imoussoura.loginascreen_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText mNameEt, mAgeEt;
    CheckBox mRemember;
    Button mBtn;
    SharedPreferences sharedPreferences;
    boolean isRemembred=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNameEt=findViewById(R.id.nameEt);
        mAgeEt=findViewById(R.id.ageEt);
        mRemember=findViewById(R.id.checkBox);
        mBtn=findViewById(R.id.login);
        sharedPreferences=getSharedPreferences("SHARED_PREF",MODE_PRIVATE);
       isRemembred= sharedPreferences.getBoolean("CHECKBOX",false);
       if(isRemembred){
           Intent intent =new Intent(MainActivity.this,InformationActivity.class);
           startActivity(intent);
           finish();
       }


        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=mNameEt.getText().toString();
                int age=Integer.parseInt(mAgeEt.getText().toString().trim());
                boolean checked=mRemember.isChecked();
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("NAME",name);
                editor.putInt("AGE",age);
                editor.putBoolean("CHECKBOX",checked);
                editor.apply();
                Toast.makeText(MainActivity.this, "Information Saved!", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(MainActivity.this,InformationActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}