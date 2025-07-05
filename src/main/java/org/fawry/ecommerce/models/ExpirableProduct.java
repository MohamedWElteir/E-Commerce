package org.fawry.ecommerce.models;

import org.fawry.ecommerce.abstracts.Product;
import org.fawry.ecommerce.interfaces.Expirable;

import java.time.LocalDate;

public class ExpirableProduct extends Product implements Expirable {
    private final LocalDate expirationDate;

    public ExpirableProduct(String name, double price, int quantity, LocalDate expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() { return expirationDate;  }

    public boolean isExpired() {
        return expirationDate != null && expirationDate.isBefore(LocalDate.now());
    }

}
