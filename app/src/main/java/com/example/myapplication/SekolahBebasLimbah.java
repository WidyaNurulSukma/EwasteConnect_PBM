package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.List;

public class SekolahBebasLimbahActivity extends AppCompatActivity {

    private RecyclerView recyclerViewSekolah;
    private SchoolAdapter adapter;
    private List<String> schoolList;
    private List<String> schoolListFull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sekolah_bebas_limbah);

        // Tombol Kembali
        ImageView btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> finish());

        // Tombol Daftar Sekolah
        Button btnDaftarSekolah = findViewById(R.id.btn_daftar_sekolah);
        btnDaftarSekolah.setOnClickListener(v -> {
            // Logika untuk membuka form pendaftaran sekolah (contoh: pindah ke aktivitas baru)
            Intent intent = new Intent(this, DaftarSekolahActivity.class); // Ganti dengan aktivitas pendaftaran yang sesuai
            startActivity(intent);
        });

        // Search Bar
        EditText searchBar = findViewById(R.id.search_bar);
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterSchools(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // RecyclerView untuk Daftar Sekolah
        recyclerViewSekolah = findViewById(R.id.recycler_view_sekolah);
        recyclerViewSekolah.setLayoutManager(new LinearLayoutManager(this));

        // Inisialisasi data sekolah
        schoolList = new ArrayList<>();
        schoolListFull = new ArrayList<>();
        initializeSchoolData();

        adapter = new SchoolAdapter(schoolList);
        recyclerViewSekolah.setAdapter(adapter);

        // Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_donate);
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
                    intent = new Intent(this, BantuanActivity.class);
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
    }

    private void initializeSchoolData() {
        schoolListFull.add("SMAN 1 Banda Aceh");
        schoolListFull.add("SMAN 1 Banda Aceh");
        schoolListFull.add("SMAN 1 Banda Aceh");
        schoolListFull.add("SMAN 1 Banda Aceh");
        schoolListFull.add("SMAN 1 Banda Aceh");
        schoolList.addAll(schoolListFull); // Inisialisasi daftar awal
    }

    private void filterSchools(String query) {
        schoolList.clear();
        if (query.isEmpty()) {
            schoolList.addAll(schoolListFull);
        } else {
            String filteredQuery = query.toLowerCase();
            for (String school : schoolListFull) {
                if (school.toLowerCase().contains(filteredQuery)) {
                    schoolList.add(school);
                }
            }
        }
        adapter.notifyDataSetChanged();
    }

    // Adapter class untuk RecyclerView
    public static class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.ViewHolder> {
        private List<String> schoolList;

        SchoolAdapter(List<String> schoolList) {
            this.schoolList = schoolList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sekolah, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.schoolName.setText(schoolList.get(position));
        }

        @Override
        public int getItemCount() {
            return schoolList.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView schoolName;

            ViewHolder(View itemView) {
                super(itemView);
                schoolName = itemView.findViewById(R.id.school_name);
            }
        }
    }
}