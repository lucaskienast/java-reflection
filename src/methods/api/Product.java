package methods.api;

import java.time.LocalDate;

public class Product {

    private double price;
    private String name;
    private long quantity;
    private LocalDate expirationDate;

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public long getQuantity() {
        return quantity;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
