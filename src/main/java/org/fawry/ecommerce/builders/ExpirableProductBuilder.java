package org.fawry.ecommerce.builders;

import org.fawry.ecommerce.abstracts.Product;
import org.fawry.ecommerce.interfaces.ProductBuilder;
import org.fawry.ecommerce.models.ExpirableProduct;

import java.util.Date;

public class ExpirableProductBuilder implements ProductBuilder {
    @Override
    public Product build(String name, double price, int quantity, Date expiry, double weight, double shippingFee) {
        return new ExpirableProduct(name, price, quantity, expiry);
    }
}
