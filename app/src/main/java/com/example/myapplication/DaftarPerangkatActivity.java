package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DaftarPerangkatActivity extends AppCompatActivity {

    private ImageView btnBack;
    private EditText etSearch;
    private TextView chipGadget, chipRumah, chipPeralatan;
    private RecyclerView rvProducts;

    private ProductAdapter productAdapter;
    private List<Product> productList;
    private List<Product> filteredList;

    private int selectedCategory = 0; // 0: Gadget, 1: Rumah Tangga, 2: Peralatan Kantor

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_perangkat);

        initViews();
        setupData();
        setupRecyclerView();
        setupListeners();
        updateCategoryChips();
    }

    private void initViews() {
        btnBack = findViewById(R.id.btn_back);
        etSearch = findViewById(R.id.et_search);
        chipGadget = findViewById(R.id.chip_gadget);
        chipRumah = findViewById(R.id.chip_rumah);
        chipPeralatan = findViewById(R.id.chip_peralatan);
        rvProducts = findViewById(R.id.rv_products);
    }

    private void setupData() {
        productList = new ArrayList<>();

        // Gadget & Aksesori
        productList.add(new Product("Smartphone", 3, R.drawable.img_smartphone, false, false, 0));
        productList.add(new Product("Tablet", 1, R.drawable.img_tablet, true, false, 0));
        productList.add(new Product("Smart Watch", 1, R.drawable.img_smartwatch, false, true, 0));
        productList.add(new Product("PlayStation", 1, R.drawable.img_playstation, false, false, 0));
        productList.add(new Product("Kamera Digital", 1, R.drawable.img_camera, true, false, 0));
        productList.add(new Product("Headset Tali", 1, R.drawable.img_headset, false, true, 0));

        // Rumah Tangga (contoh data tambahan)
        productList.add(new Product("Rice Cooker", 2, R.drawable.img_rice_cooker, false, false, 1));
        productList.add(new Product("Blender", 1, R.drawable.img_blender, false, false, 1));

        // Peralatan Kantor (contoh data tambahan)
        productList.add(new Product("Printer", 1, R.drawable.img_printer, false, false, 2));
        productList.add(new Product("Scanner", 2, R.drawable.img_scanner, false, false, 2));

        filteredList = new ArrayList<>();
        filterProducts();
    }

    private void setupRecyclerView() {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        rvProducts.setLayoutManager(layoutManager);

        productAdapter = new ProductAdapter(filteredList, new ProductAdapter.OnProductClickListener() {
            @Override
            public void onProductClick(Product product) {
                // Handle product click
                // Intent ke detail product atau action lainnya
            }

            @Override
            public void onFavoriteClick(Product product, int position) {
                product.setFavorite(!product.isFavorite());
                productAdapter.notifyItemChanged(position);
            }
        });

        rvProducts.setAdapter(productAdapter);
    }

    private void setupListeners() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterProducts();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        chipGadget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedCategory = 0;
                updateCategoryChips();
                filterProducts();
            }
        });

        chipRumah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedCategory = 1;
                updateCategoryChips();
                filterProducts();
            }
        });

        chipPeralatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedCategory = 2;
                updateCategoryChips();
                filterProducts();
            }
        });
    }

    private void updateCategoryChips() {
        // Reset all chips
        chipGadget.setBackgroundResource(R.drawable.chip_unselected);
        chipRumah.setBackgroundResource(R.drawable.chip_unselected);
        chipPeralatan.setBackgroundResource(R.drawable.chip_unselected);

        // Set selected chip
        switch (selectedCategory) {
            case 0:
                chipGadget.setBackgroundResource(R.drawable.chip_selected);
                break;
            case 1:
                chipRumah.setBackgroundResource(R.drawable.chip_selected);
                break;
            case 2:
                chipPeralatan.setBackgroundResource(R.drawable.chip_selected);
                break;
        }
    }

    private void filterProducts() {
        filteredList.clear();
        String searchText = etSearch.getText().toString().toLowerCase().trim();

        for (Product product : productList) {
            // Filter by category
            if (product.getCategory() != selectedCategory) {
                continue;
            }

            // Filter by search text
            if (searchText.isEmpty() || product.getName().toLowerCase().contains(searchText)) {
                filteredList.add(product);
            }
        }

        if (productAdapter != null) {
            productAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}