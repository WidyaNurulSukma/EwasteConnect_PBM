package com.example.myapplication; // Ganti dengan package kamu

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class DonasiPerangkatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donasi_perangkat); // Ganti sesuai nama layout XML kamu

        // Aksi saat CardView "Daftar Perangkat" ditekan
        CardView btnDaftarPerangkat = findViewById(R.id.btn_daftar_perangkat);
        btnDaftarPerangkat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke DaftarPerangkatActivity
                Intent intent = new Intent(DonasiPerangkatActivity.this, DaftarPerangkatActivity.class);
                startActivity(intent);
            }
        });

        // (Opsional) Aksi tombol kembali, pastikan ID-nya sesuai di layout
        View btnBack = findViewById(R.id.btn_back);
        if (btnBack != null) {
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish(); // Kembali ke halaman sebelumnya
                }
            });
        }
    }
}
