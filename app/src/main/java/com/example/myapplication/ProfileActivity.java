package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile); // WAJIB ADA

        // Tombol Kembali
        ImageView btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> finish());

        // Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_profile);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Intent intent = null;
            switch (item.getItemId()) {
                case R.id.nav_home:
                    intent = new Intent(this, MainActivity.class);
                    break;
                case R.id.nav_donate:
                    intent = new Intent(this, DonasiActivity.class);
                    break;
                case R.id.nav_help:
                    intent = new Intent(this, PanduanActivity.class);
                    break;
                case R.id.nav_profile:
                    return true;
                default:
                    return false;
            }
            if (intent != null) {
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
            return true;
        });

        // Klik pada item menu (simulasi pencitraan saja)
        findViewById(R.id.layout_rating).setOnClickListener(v -> {
            // Simulasi aksi
        });
        findViewById(R.id.layout_about).setOnClickListener(v -> {
            // Simulasi aksi
        });
        findViewById(R.id.layout_logout).setOnClickListener(v -> {
            // Simulasi aksi
        });
    }
}
