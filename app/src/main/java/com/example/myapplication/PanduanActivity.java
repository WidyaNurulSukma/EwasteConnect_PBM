package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.List;

public class PanduanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panduan);

        // Tombol Kembali
        ImageView btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> finish());


        // Data langkah-langkah

        StepAdapter adapter = new StepAdapter(stepList);
        recyclerView.setAdapter(adapter);

        // Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_help);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Intent intent = null;
            switch (item.getItemId()) {
                case R.id.nav_home:
                    intent = new Intent(this, MainActivity.class);
                    break;
                case R.id.nav_donate:
                    intent = new Intent(this, DonasiActivity.class);
                    break;
                case R.id.nav_help:
                    return true;
                case R.id.nav_profile:

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
    }

    // Model class
    public static class Step {
        String number;
        String title;
        int imageResId;

        Step(String number, String title, int imageResId) {
            this.number = number;
            this.title = title;
            this.imageResId = imageResId;
        }
    }

    // Adapter class
    public static class StepAdapter extends RecyclerView.Adapter<StepAdapter.ViewHolder> {
        private final List<Step> stepList;

        StepAdapter(List<Step> stepList) {
            this.stepList = stepList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_step, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Step step = stepList.get(position);
            holder.stepNumber.setText(step.number);
            holder.stepTitle.setText(step.title);
            holder.stepImage.setImageResource(step.imageResId);
        }

        @Override
        public int getItemCount() {
            return stepList.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView stepNumber;
            TextView stepTitle;
            ImageView stepImage;

            }
        }
    }
}
