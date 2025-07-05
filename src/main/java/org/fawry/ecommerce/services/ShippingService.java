package org.fawry.ecommerce.services;

import org.fawry.ecommerce.models.Cart;

import java.util.List;

public class ShippingService {

    public void ship(List<Cart.ShippableItems> items){
        System.out.println("Shipping the following items:");
        for(var item : items){
            System.out.println(
                   item.quantity() + "x " + item.name() + ',' +
                    " Weight: " + item.weight() + " kg"+ ',' +
                    " Shipping Fee: " + item.shippingFee());
        }
    }
}
