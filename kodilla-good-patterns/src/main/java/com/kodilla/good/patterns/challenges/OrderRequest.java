package com.kodilla.good.patterns.challenges;

public class OrderRequest {
    public Customer customer;
    public Product product;

    public OrderRequest(final Customer customer, final Product product) {
        this.customer = customer;
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }
}
