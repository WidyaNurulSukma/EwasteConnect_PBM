package com.example.myapplication;

public class Product {
    private String name;
    private int stock;
    private int imageResource;
    private boolean isNew;
    private boolean isFavorite;
    private int category; // 0: Gadget, 1: Rumah Tangga, 2: Peralatan Kantor

    public Product(String name, int stock, int imageResource, boolean isNew, boolean isFavorite, int category) {
        this.name = name;
        this.stock = stock;
        this.imageResource = imageResource;
        this.isNew = isNew;
        this.isFavorite = isFavorite;
        this.category = category;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public int getImageResource() {
        return imageResource;
    }

    public boolean isNew() {
        return isNew;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public int getCategory() {
        return category;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }

    public void setFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}