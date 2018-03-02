package com.kodilla.good.patterns.challenges;

public class Product {
    private int productId;
    private String name;
    private String description;

    public Product(int productId, String name, String description) {
        this.productId = productId;
        this.name = name;
        this.description = description;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
