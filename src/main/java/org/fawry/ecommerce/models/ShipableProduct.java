package org.fawry.ecommerce.models;

import org.fawry.ecommerce.abstracts.Product;
import org.fawry.ecommerce.interfaces.Shippable;

public class ShipableProduct extends Product implements Shippable {
    private final double weight;
    private final double shippingFee;

    public ShipableProduct(String name, double price, int quantity, double weight, double shippingFee) {
        super(name, price, quantity);
        this.weight = weight;
        this.shippingFee = shippingFee;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public double getShippingFee() {
        return shippingFee;
    }
}
