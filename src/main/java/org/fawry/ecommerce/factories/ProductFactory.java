package org.fawry.ecommerce.factories;


import org.fawry.ecommerce.abstracts.Product;
import org.fawry.ecommerce.abstracts.ProductType;
import org.fawry.ecommerce.interfaces.ProductBuilder;

import java.time.LocalDate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ProductFactory {
    private static final Map<ProductType, ProductBuilder> builders = new ConcurrentHashMap<>();


    public static void registerBuilder(ProductType type, ProductBuilder builder) {
        if (type == null) throw new IllegalArgumentException("Product type cannot be null");
        builders.put(type, builder);
    }

    public static ProductBuilder getBuilder(ProductType type) {
        return builders.get(type);
    }

    public static Product create(ProductType type, String name, double price, int quantity, LocalDate expiry, double weight, double shippingFee){
        if (type == null) throw new IllegalArgumentException("Product type cannot be null");
        var builder = builders.get(type);
        if (builder == null) throw new IllegalArgumentException("No builder registered for type: " + type);
        return builder.build(name, price, quantity, expiry, weight, shippingFee);
    }
}
