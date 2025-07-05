package org.fawry.ecommerce.interfaces;

import org.fawry.ecommerce.abstracts.Product;

import java.time.LocalDate;

public interface ProductBuilder {
    Product build(String name, double price, int quantity, LocalDate expiry, double weight, double shippingFee);
}
