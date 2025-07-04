package org.example;

public class Product {
    String name;
    double price;
    int quantity;
    boolean isExpirable;
    boolean isShippable;
    double weight; // in grams
    boolean expired;

    public Product(String name, double price, int quantity,
                   boolean isExpirable, boolean isShippable,
                   double weight, boolean expired) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isExpirable = isExpirable;
        this.isShippable = isShippable;
        this.weight = weight;
        this.expired = expired;
    }

    public boolean isAvailable(int qty) {
        return quantity >= qty && (!isExpirable || !expired);
    }

    public void reduceQuantity(int qty) {
        quantity -= qty;
    }
}
