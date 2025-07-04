package org.fawry.ecommerce.models;

import org.fawry.ecommerce.abstracts.Product;
import org.fawry.ecommerce.interfaces.Shippable;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity){
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException("Product cannot be null and quantity must be greater than zero");
        }
        if(product.getQuantity() < quantity) throw new IllegalArgumentException("Insufficient product quantity in stock");
        var item = items.stream()
                .filter(i -> i.product.equals(product))
                .findFirst();

        if (item.isPresent()) {
            CartItem cartItem = item.get();
            cartItem.setQuantity(cartItem.getQuantity() + quantity);


        }else {
            items.add(new CartItem(product, quantity));
        }
        product.reduceQuantity(quantity);

    }

    public boolean removeItem(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        return items.removeIf(item -> item.getProduct().equals(product));
    }

    public List<CartItem> getItems() {return items;  }

    public double calculateSubtotal(){
        return items.stream().mapToDouble(
                item -> item.getProduct().getPrice() * item.getQuantity()
        ).sum();
    }

    public void clearCart() {
        items.clear();
    }
    public double calculateShipping(){
        return items.stream().filter(item -> item.getProduct() instanceof Shippable)
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity() * ((Shippable) item.getProduct()).getShippingFee())
                .sum();
    }

    public boolean isEmpty() {return items.isEmpty();}

    public List<Shippable> getShippableItems() {
        return items.stream()
                .filter(i -> i.product instanceof Shippable)
                .map(i -> (Shippable) i.product)
                .toList();
    }

}
