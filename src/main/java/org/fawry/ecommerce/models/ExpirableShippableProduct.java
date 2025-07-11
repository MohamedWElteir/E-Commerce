package org.fawry.ecommerce.models;

import org.fawry.ecommerce.interfaces.Shippable;

import java.time.LocalDate;

public class ExpirableShippableProduct extends ExpirableProduct implements Shippable {
    private final double weight;
    private final double shippingFee;

    public ExpirableShippableProduct(String name, double price, int quantity, LocalDate expirationDate, double weight, double shippingFee) {
        super(name, price, quantity, expirationDate);
        this.weight = weight;
        this.shippingFee = shippingFee;
    }

    public double getWeight() { return weight;  }

    @Override
    public double getShippingFee() {
        return shippingFee;
    }
}
