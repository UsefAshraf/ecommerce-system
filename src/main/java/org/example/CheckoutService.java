package org.example;
import java.util.*;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        }

        for (CartItem item : cart.items) {
            if (!item.product.isAvailable(item.quantity)) {
                System.out.println("Error: One or more products are out of stock or expired.");
                return;
            }
        }

        double subtotal = cart.getSubtotal();
        double shippingFee = cart.getShippingWeight() > 0 ? 30 : 0;
        double total = subtotal + shippingFee;

        if (!customer.canPay(total)) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        for (CartItem item : cart.items) {
            item.product.reduceQuantity(item.quantity);
        }

        customer.pay(total);

        if (shippingFee > 0) {
            ShippingService.ship(cart.getShippables());
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.items) {
            System.out.printf("%dx %-10s %.0f\n", item.quantity, item.product.name, item.product.price * item.quantity);
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal\t%.0f\n", subtotal);
        System.out.printf("Shipping\t%.0f\n", shippingFee);
        System.out.printf("Amount\t\t%.0f\n", total);
        System.out.printf("Customer balance: %.0f\n", customer.balance);
    }
}
