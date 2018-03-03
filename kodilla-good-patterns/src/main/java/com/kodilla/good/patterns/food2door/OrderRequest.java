package com.kodilla.good.patterns.food2door;

public class OrderRequest {
    private String productName;
    private int quantity;

    public OrderRequest(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductName() {return productName;
    }

    public int getQuantity() {return quantity;
    }
}
