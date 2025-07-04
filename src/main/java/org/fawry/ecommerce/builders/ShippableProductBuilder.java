package org.fawry.ecommerce.builders;

import org.fawry.ecommerce.abstracts.Product;
import org.fawry.ecommerce.interfaces.ProductBuilder;
import org.fawry.ecommerce.models.ShipableProduct;

import java.util.Date;

public class ShippableProductBuilder implements ProductBuilder {
    public Product build(String name, double price, int quantity, Date expiry, double weight, double shippingFee) {
        return new ShipableProduct(name, price, quantity, weight, shippingFee);
    }
}
