package org.example;
import java.util.List;

public class ShippingService {
    public static void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (Shippable item : items) {
            System.out.printf("%s\t%.0fg\n", item.getName(), item.getWeight());
            totalWeight += item.getWeight();
        }
        System.out.printf("Total package weight %.1fkg\n\n", totalWeight / 1000.0);
    }
}