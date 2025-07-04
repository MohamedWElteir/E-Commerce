package org.fawry.ecommerce.handlers;

import org.fawry.ecommerce.abstracts.CheckoutValidation;
import org.fawry.ecommerce.interfaces.Expirable;
import org.fawry.ecommerce.models.Cart;

public class ExpiryHandler extends CheckoutValidation {
    @Override
    protected void check(Cart cart, double balance) {
        var ExpiredItems = cart.getItems().stream()
                            .filter(i->i.getProduct() instanceof Expirable &&
                                         ((Expirable)i.getProduct())
                                                 .isExpired())
                                                    .toList();
        if(!ExpiredItems.isEmpty()) throw new IllegalArgumentException("Cart contains expired items" + ExpiredItems);
    }
}
