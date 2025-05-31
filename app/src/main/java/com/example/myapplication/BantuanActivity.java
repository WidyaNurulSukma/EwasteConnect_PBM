package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BantuanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan);

        // Tombol Kembali
        ImageView btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> finish());

        // Tombol Media Sosial
        findViewById(R.id.btn_whatsapp).setOnClickListener(v -> openLink("https://wa.me/your_whatsapp_number")); // Ganti dengan nomor WhatsApp yang valid
        findViewById(R.id.btn_instagram).setOnClickListener(v -> openLink("https://www.instagram.com/your_instagram_handle")); // Ganti dengan akun Instagram yang valid
        findViewById(R.id.btn_tiktok).setOnClickListener(v -> openLink("https://www.tiktok.com/@your_tiktok_handle")); // Ganti dengan akun TikTok yang valid

        // Logika Expand/Collapse untuk FAQ
        setupFAQItem(R.id.faq_question_1, R.id.faq_answer_1);
        setupFAQItem(R.id.faq_question_2, R.id.faq_answer_2);
        setupFAQItem(R.id.faq_question_3, R.id.faq_answer_3);
        setupFAQItem(R.id.faq_question_4, R.id.faq_answer_4);

        // Navigasi Bawah - DINONAKTIFKAN agar tidak error
        /*
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_help);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            return true;
        });
        */
    }

    private void openLink(String url) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            android.widget.Toast.makeText(this, "Tidak dapat membuka tautan. Pastikan aplikasi terkait terinstal.", android.widget.Toast.LENGTH_SHORT).show();
        }
    }

    private void setupFAQItem(int questionId, int answerId) {
        TextView question = findViewById(questionId);
        TextView answer = findViewById(answerId);
        question.setOnClickListener(v -> {
            if (answer.getVisibility() == View.VISIBLE) {
                answer.setVisibility(View.GONE);
            } else {
                answer.setVisibility(View.VISIBLE);
            }
        });
    }
}
