package com.kodilla.good.patterns.challenges;

public class Customer {
    private int customerId;
    private String name;
    private String surname;
    private String email;

    public Customer(int customerId, String name, String surname, String email) {
        this.customerId = customerId;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }
}
