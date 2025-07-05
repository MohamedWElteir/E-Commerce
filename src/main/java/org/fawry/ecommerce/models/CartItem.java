package org.fawry.ecommerce.models;

import org.fawry.ecommerce.abstracts.Product;

public class CartItem {
   private final Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        if(quantity < 0) {
            throw new IllegalArgumentException("Cart quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{ " +
                "product=" + product.getName()+
                ", quantity=" + quantity +
                '}';
    }
}
