package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Product cheese = new Product("Cheese", 100, 10, true, true, 200, false);
        Product biscuits = new Product("Biscuits", 150, 5, true, true, 700, false);
        Product tv = new Product("TV", 3000, 2, false, true, 8000, false);
        Product scratchCard = new Product("ScratchCard", 50, 20, false, false, 0, false);

        Customer customer = new Customer("Ahmed", 1000);
        Cart cart = new Cart();

        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);

        CheckoutService.checkout(customer, cart);
    }
}
