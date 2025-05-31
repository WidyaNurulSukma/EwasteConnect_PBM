package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // EdgeToEdge.enable(this); // Dinonaktifkan sementara
        setContentView(R.layout.activity_main);

        // Menangani window insets
        View mainLayout = findViewById(R.id.main);
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Mengatur listener untuk TextView eWaste
        TextView tvAppName = findViewById(R.id.tvAppName);
        tvAppName.setClickable(true);
        tvAppName.setFocusable(true);
        tvAppName.setOnClickListener(v -> {
            Log.d("MainActivity", "eWaste TextView clicked");
            SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            boolean hasSeenOnboarding = preferences.getBoolean("hasSeenOnboarding", false);
            if (!hasSeenOnboarding) {
                Log.d("MainActivity", "Starting OnboardingActivity");
                Intent intent = new Intent(MainActivity.this, OnboardingActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0); // Nonaktifkan animasi
            } else {
                Log.d("MainActivity", "Onboarding already seen");
            }
        });
    }
}