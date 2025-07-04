package org.fawry.ecommerce.interfaces;

import org.fawry.ecommerce.abstracts.Product;

import java.util.Date;

public interface ProductBuilder {
    Product build(String name, double price, int quantity, Date expiry, double weight, double shippingFee);
}
