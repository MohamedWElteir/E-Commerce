package org.fawry.ecommerce.services;

import org.fawry.ecommerce.interfaces.Shippable;

import java.util.List;

public class ShippingService {

    public void ship(List<Shippable> items){
        System.out.println("Shipping the following items:");
        for(Shippable item : items){
            System.out.println(
                    "Item: " + item.getName() + ',' +
                    " Weight: " + item.getWeight() + " kg"+ ',' +
                    " Shipping Fee: " + item.getShippingFee());
        }
    }
}
