package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class RegistrationSuccessActivity extends AppCompatActivity {
    private Button btnLogin;
    private TextView tvLogin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_success); // ✅ Pastikan file XML namanya benar

        // Inisialisasi view
        btnLogin = findViewById(R.id.btnMasuk); // ✅ Disesuaikan dengan ID di layout
        tvLogin2 = findViewById(R.id.tvLogin2); // ✅ Sudah ada di layout

        // Aksi klik tombol "Masuk"
        btnLogin.setOnClickListener(view -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });

        // Aksi klik teks "Login sekarang"
        tvLogin2.setOnClickListener(view -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }
}
