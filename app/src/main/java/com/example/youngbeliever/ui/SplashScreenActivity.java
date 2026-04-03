package com.example.youngbeliever.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youngbeliever.R;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity
{
    private static final int SPLASH_DURATION = 7000; // 3 seconds
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        ImageView logo = findViewById(R.id.logo);
        logo.animate().alpha(1f).setDuration(1000).setStartDelay(500).start();
        // Delay then move to main activity
        new Handler().postDelayed(() ->
        {
            startActivity(new Intent(SplashScreenActivity.this, HomeActivity.class));
            finish();
        }, SPLASH_DURATION);
    }
}