package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class OnboardingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        // Sembunyikan action bar
        getSupportActionBar().hide();

        // Tampilkan dalam mode full screen
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        // Set tombol Mulai
        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(v -> {
            // Pindah ke MainActivity
            Intent intent = new Intent(OnboardingActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Optional: jika tidak ingin user kembali ke screen ini
        });
    }
}
