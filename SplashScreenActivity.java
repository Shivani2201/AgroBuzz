package com.example.agrobuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {
    private long ms = 0;
    private long splashDuration = 2000;
    private boolean splashActive = true;
    private boolean paused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread mythread = new Thread() {
            public void run() {
                try {
                    while (splashActive && ms < splashDuration) {
                        if (!paused)
                            ms = ms + 100;
                        sleep(100);
                    }
                } catch (Exception e) {
                } finally {
                    Intent intent = new Intent(SplashScreenActivity.this,
                            LoginActivity.class);
                    startActivity(intent);
                }
            }
        };
        mythread.start();

    }
}
