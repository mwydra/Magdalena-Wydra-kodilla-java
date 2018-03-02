package com.kodilla.good.patterns.challenges;

public class OrderRequestRetriever {
    Customer customer = new Customer(1, "Jan", "Jankowski", "jan.jankowski@mail.com");
    Product product = new Product(1, "Colgate", "Szczotka do zębów");

    public OrderRequest retrieve(){
        return new OrderRequest(customer, product);
    }
}
