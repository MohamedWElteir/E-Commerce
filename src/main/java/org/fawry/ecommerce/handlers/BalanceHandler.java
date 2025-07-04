package org.fawry.ecommerce.handlers;

import org.fawry.ecommerce.abstracts.CheckoutValidation;
import org.fawry.ecommerce.models.Cart;

public class BalanceHandler extends CheckoutValidation {
    @Override
    protected void check(Cart cart, double balance) {
        var total = cart.calculateSubtotal() + cart.calculateShipping();
        if(total > balance) throw new IllegalArgumentException("Balance is not enough");
    }
}
