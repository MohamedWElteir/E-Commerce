package org.fawry.ecommerce.handlers;

import org.fawry.ecommerce.abstracts.CheckoutValidation;
import org.fawry.ecommerce.models.Cart;

public class EmptyCartHandler extends CheckoutValidation {
    @Override
    protected void check(Cart cart, double balance) {
        if(cart.isEmpty()) throw new IllegalArgumentException("Cart is empty");
    }
}
