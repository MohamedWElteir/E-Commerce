package org.fawry.ecommerce.services;

import org.fawry.ecommerce.abstracts.CheckoutValidation;
import org.fawry.ecommerce.interfaces.Shippable;
import org.fawry.ecommerce.models.Customer;

import java.util.List;

public class CheckoutService {
    private final Customer customer;
    private final CheckoutValidation validation;
    private final ShippingService shippingService;

    public CheckoutService(Customer customer, CheckoutValidation validation, ShippingService shippingService) {
        this.customer = customer;
        this.validation = validation;
        this.shippingService = shippingService;
    }
    public void checkout() {
         final String GREEN = "\u001B[32m";
         final String RESET = "\u001B[0m";
        validation.handle(customer.getCart(), customer.getBalance());
        var subtotal = customer.getCart().calculateSubtotal();
        var shipping = customer.getCart().calculateShipping();
        var total = subtotal + shipping;
        customer.deductBalance(total);
        System.out.println(
                         GREEN +
                        "=== Checkout Summary ===\n" +
                        "Subtotal: $" + subtotal + "\n" +
                        "Shipping: $" + shipping + "\n" +
                        "Total Paid: $" + total + '\n' +
                        "Balance Left: $" + customer.getBalance() +
                        RESET
        );

        List<Shippable> shippable = customer.getCart().getShippableItems();
        shippingService.ship(shippable);
        customer.getCart().clearCart();
    }
}
