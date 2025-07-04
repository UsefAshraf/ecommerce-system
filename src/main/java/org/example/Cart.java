package org.example;
//import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (product.isAvailable(quantity)) {
            items.add(new CartItem(product, quantity));
        } else {
            System.out.println("Error: Product out of stock or expired.");
        }
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubtotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.product.price * item.quantity;
        }
        return total;
    }

    public double getShippingWeight() {
        double totalWeight = 0;
        for (CartItem item : items) {
            if (item.product.isShippable) {
                totalWeight += item.product.weight * item.quantity;
            }
        }
        return totalWeight;
    }

    public List<Shippable> getShippables() {
        List<Shippable> list = new ArrayList<>();
        for (CartItem item : items) {
            if (item.product.isShippable) {
                Product p = item.product;
                int qty = item.quantity;
                list.add(new Shippable() {
                    public String getName() { return qty + "x " + p.name; }
                    public double getWeight() { return p.weight * qty; }
                });
            }
        }
        return list;
    }
}