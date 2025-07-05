package org.fawry.ecommerce.abstracts;

import org.fawry.ecommerce.models.Cart;

public abstract class CheckoutValidation {
    protected CheckoutValidation next;

    public CheckoutValidation setNext(CheckoutValidation validator){
        this.next = validator;
        return validator;
    }
    public void handle(Cart cart, double balance){
        check(cart,balance);
        if(next != null){
            next.handle(cart,balance);
        }
    }

    protected abstract void check(Cart cart, double balance);
}
