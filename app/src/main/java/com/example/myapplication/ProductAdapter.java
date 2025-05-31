package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList;
    private OnProductClickListener listener;

    public interface OnProductClickListener {
        void onProductClick(Product product);
        void onFavoriteClick(Product product, int position);
    }

    public ProductAdapter(List<Product> productList, OnProductClickListener listener) {
        this.productList = productList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.bind(product, position);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivProduct;
        private TextView tvNewBadge;
        private ImageView ivFavorite;
        private TextView tvProductName;
        private TextView tvStockInfo;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            ivProduct = itemView.findViewById(R.id.iv_product);
            tvNewBadge = itemView.findViewById(R.id.tv_new_badge);
            ivFavorite = itemView.findViewById(R.id.iv_favorite);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvStockInfo = itemView.findViewById(R.id.tv_stock_info);
        }

        public void bind(Product product, int position) {
            // Set product image
            ivProduct.setImageResource(product.getImageResource());

            // Set product name
            tvProductName.setText(product.getName());

            // Set stock info
            tvStockInfo.setText("Ketersediaan barang: " + product.getStock());

            // Sembunyikan elemen yang tidak dipakai
            tvNewBadge.setVisibility(View.GONE);
            ivFavorite.setVisibility(View.GONE);

            // Click hanya untuk item, bukan favorit
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onProductClick(product);
                    }
                }
            });
        }
    }
}