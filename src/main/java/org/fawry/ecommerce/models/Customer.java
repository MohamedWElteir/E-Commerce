package org.fawry.ecommerce.models;

public class Customer {
   private String name;
   private final Cart cart = new Cart();
   private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {return name;}
    public Cart getCart() { return cart;}
    public double getBalance() { return balance; }

    public void setName(String name) {
        this.name = name;
    }

    public void deductBalance(double amount) {
        if(amount > balance) throw new IllegalStateException("Insufficient balance");
        this.balance -= amount;
    }
}
