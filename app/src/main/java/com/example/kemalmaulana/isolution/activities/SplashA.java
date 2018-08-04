package com.example.kemalmaulana.isolution.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.kemalmaulana.isolution.R;

public class SplashA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // do verification on SharedPreferences
                startActivity(new Intent(SplashA.this, LoginA.class));
            }
        });
    }
}
