package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    TextView txtemail,txtusername;
    SharedPreferences sharedPreferences;
    private static final String Shared_Pref_name="mypref";
    private static final String KEY_username1="syednofel";
    private static final String KEY_email="syednofel7281@gmail.com";

    Button logout;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        txtusername=findViewById(R.id.textView3);
        txtemail=findViewById(R.id.textView4);
        logout=findViewById(R.id.logout);

        sharedPreferences=getSharedPreferences(Shared_Pref_name,MODE_PRIVATE);
        String stringusername=sharedPreferences.getString(KEY_username1,null);
        String stringemail=sharedPreferences.getString(KEY_email,null);

        txtusername.setText("your name is "+stringusername);
        txtemail.setText("your email is "+stringemail);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.apply();
                Toast.makeText(MainActivity3.this, "Log out Succesfully!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}