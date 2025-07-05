package org.fawry.ecommerce.builders;

import org.fawry.ecommerce.abstracts.Product;
import org.fawry.ecommerce.interfaces.ProductBuilder;

import java.time.LocalDate;

public class GenericProductBuilder implements ProductBuilder {
    public Product build(String name, double price, int quantity, LocalDate expiry, double weight, double shippingFee) {
        return new Product(name, price,quantity) {
            public boolean isExpired() { return false; }
        };
    }
}
