package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PengaturanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);

        // Tombol Kembali
        ImageView btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> finish());

        // Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_profile); // Sesuaikan dengan konteks navigasi
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
                    intent = new Intent(this, ProfileActivity.class);
                    break;
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

        // Klik pada opsi bahasa (simulasi)
        findViewById(R.id.layout_language).setOnClickListener(v -> {
            // Logika untuk mengubah bahasa
        });

        // Klik pada opsi hapus akun (simulasi)
        findViewById(R.id.layout_delete_account).setOnClickListener(v -> {
            // Logika untuk hapus akun
        });
    }
}
