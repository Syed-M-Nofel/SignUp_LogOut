package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView txtemail, txtusername;
    SharedPreferences sharedPreferences;
    Button signin;

    private static final String Shared_Pref_name="mypref";
    private static final String KEY_username1="syednofel";
    private static final String KEY_email="syednofel7281@gmail.com";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtusername=findViewById(R.id.editTextTextEmailAddress2);
        txtemail=findViewById(R.id.editTextTextPersonName);
        signin=findViewById(R.id.signin);

        sharedPreferences=getSharedPreferences(Shared_Pref_name,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtusername.getText().length()==0)
                {
                    txtusername.setError("Kindly enter your username");
                }
                else if(txtemail.getText().length()==0)
                {
                    txtemail.setError("Kindly enter Your email");
                }
                else
                {
                    editor.putString(KEY_username1,txtusername.getText().toString());
                    editor.putString(KEY_email,txtemail.getText().toString());
                    editor.apply();
                    Toast.makeText(MainActivity2.this,"Log in successfully", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(MainActivity2.this,MainActivity3.class);
                    startActivity(i);
                }
            }
        });
    }
}