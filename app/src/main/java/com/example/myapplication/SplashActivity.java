package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY = 2000; // 2 detik
    private boolean hasNavigated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Menggunakan layout yang sama dengan MainActivity

        // Hide status bar untuk full screen
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        // Set click listener untuk seluruh layar
        View rootLayout = findViewById(R.id.main);
        rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!hasNavigated) {
                    navigateToNextScreen();
                }
            }
        });

        // Auto navigate setelah delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!hasNavigated) {
                    navigateToNextScreen();
                }
            }
        }, SPLASH_DELAY);
    }

    private void navigateToNextScreen() {
        hasNavigated = true;

        // Cek apakah onboarding sudah pernah ditampilkan
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        boolean hasSeenOnboarding = preferences.getBoolean("hasSeenOnboarding", false);

        Intent intent;
        if (!hasSeenOnboarding) {
            // Jika belum pernah melihat onboarding
            intent = new Intent(SplashActivity.this, OnboardingActivity.class);
        } else {
            // Jika sudah pernah melihat onboarding, langsung ke RegisterActivity
            intent = new Intent(SplashActivity.this, RegisterActivity.class);
        }

        startActivity(intent);
        finish(); // Tutup SplashActivity
    }

    @Override
    public void onBackPressed() {
        // Disable back button pada splash screen
        // super.onBackPressed(); // Jangan panggil ini
    }
}