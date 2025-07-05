package org.fawry.ecommerce.services;

import org.fawry.ecommerce.abstracts.Product;
import org.fawry.ecommerce.interfaces.Expirable;
import org.fawry.ecommerce.models.Cart;
import org.fawry.ecommerce.models.CartItem;

import java.util.List;

public class ProductService {
    public void reduceStock(Cart cart) {
        for (CartItem item : cart.getItems().stream()
                .filter(i -> !(i.getProduct() instanceof Expirable) || !((Expirable) i.getProduct()).isExpired())
                .toList()) {

            System.out.println("Reducing the stock for " + item.getProduct().getName() + " by " + item.getQuantity() + "...");
            item.getProduct().reduceQuantity(item.getQuantity());
            System.out.println("Now stock for " + item.getProduct().getName() + " is " + item.getProduct().getQuantity());
        }
    }



}
