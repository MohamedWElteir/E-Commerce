package org.fawry.ecommerce.models;

import org.fawry.ecommerce.abstracts.Product;
import org.fawry.ecommerce.interfaces.Expirable;
import org.fawry.ecommerce.interfaces.Shippable;

import java.util.ArrayList;
import java.util.List;

public record Cart() {
    private static final List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity){
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException("Product cannot be null and quantity must be greater than zero");
        }
        if(product.getQuantity() < quantity) throw new IllegalArgumentException("Insufficient product quantity in stock");
        var item = items.stream()
                .filter(i -> i.getProduct().equals(product))
                .findFirst();

        if (item.isPresent()) {
            CartItem cartItem = item.get();
            cartItem.setQuantity(cartItem.getQuantity() + quantity);


        }else {
            items.add(new CartItem(product, quantity));
        }
//        product.reduceQuantity(quantity);

    }

    public boolean removeItem(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        return items.removeIf(item -> item.getProduct().equals(product));
    }

    public List<CartItem> getItems() {return items;  }

    public double calculateSubtotal(){
        return items.stream()
                .filter(i -> {
                    Product product = i.getProduct();
                    return !(product instanceof Expirable) || !((Expirable) product).isExpired();
                })
                .mapToDouble(
                item -> item.getProduct().getPrice() * item.getQuantity()
        ).sum();
    }

    public void clearCart() {
        items.clear();
    }
    public double calculateShipping(){
        return items.stream()
                .filter(i -> {
                    Product product = i.getProduct();
                    boolean isShippable = product instanceof Shippable;
                    boolean isNotExpired = !(product instanceof Expirable) || !((Expirable) product).isExpired();
                    return isShippable && isNotExpired;
                })
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity() * ((Shippable) item.getProduct()).getShippingFee())
                .sum();
    }

    public boolean isEmpty() {return items.isEmpty();}
    public record ShippableItems(String name, double weight, double shippingFee, int quantity) {}

    public List<ShippableItems> getShippableItems() {
        return items.stream()
                .filter(i -> {
                    Product product = i.getProduct();
                    boolean isShippable = product instanceof Shippable;
                    boolean isNotExpired = !(product instanceof Expirable) || !((Expirable) product).isExpired();
                    return isShippable && isNotExpired;
                })
                .map(i -> {
                    Shippable p = (Shippable) i.getProduct();
                    return new ShippableItems(
                            p.getName(),
                            p.getWeight(),
                            p.getShippingFee(),
                            i.getQuantity()
                    );
                })
                .toList();
    }


}

