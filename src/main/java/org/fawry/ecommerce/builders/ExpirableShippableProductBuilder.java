package org.fawry.ecommerce.builders;

import org.fawry.ecommerce.abstracts.Product;
import org.fawry.ecommerce.interfaces.ProductBuilder;
import org.fawry.ecommerce.models.ExpirableShippableProduct;

import java.util.Date;

public class ExpirableShippableProductBuilder implements ProductBuilder {
    public Product build(String name, double price, int quantity, Date expiry, double weight, double shippingFee) {
        return new ExpirableShippableProduct(name,price, quantity, expiry, weight, shippingFee);
    }
}
