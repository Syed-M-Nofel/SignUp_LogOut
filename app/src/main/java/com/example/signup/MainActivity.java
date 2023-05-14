package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView welcome;
    LottieAnimationView dots;

    SharedPreferences sharedPreferences;
    Handler handler=new Handler(Looper.getMainLooper());
    private static final String Shared_Pref_name="mypref";
    private static final String KEY_username1="syednofel";
    private static final String KEY_email="syednofel7281@gmail.com";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome=findViewById(R.id.welcome);
        dots=findViewById(R.id.dots);

        sharedPreferences=getSharedPreferences(Shared_Pref_name,MODE_PRIVATE);
        String stringusername=sharedPreferences.getString(KEY_username1,null);
        String stringemail=sharedPreferences.getString(KEY_email,null);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(stringemail!=null || stringusername!=null){
                    Intent i=new Intent(MainActivity.this,MainActivity3.class);
                    startActivity(i);
                }
                else
                {
                    Intent i=new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(i);
                }
                finish();
            }
        },3700);

    }
}