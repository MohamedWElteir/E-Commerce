package org.fawry.ecommerce.abstracts;

public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        if(name.isBlank()){
            throw new IllegalArgumentException("Product name cannot be blank");
        }
        this.name = name;
        this.price = price;
        if (quantity < 0) {
            throw new IllegalArgumentException("Product quantity cannot be negative");
        }
        this.quantity = quantity;
    }
    public String getName() { return name; }

    public double getPrice() { return price; }

    public int getQuantity() { return quantity; }

    public void reduceQuantity(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient quantity");
        }
    }

}
