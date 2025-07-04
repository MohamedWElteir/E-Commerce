package org.fawry.ecommerce.models;

import org.fawry.ecommerce.abstracts.Product;
import org.fawry.ecommerce.interfaces.Expirable;

import java.util.Date;

public class ExpirableProduct extends Product implements Expirable {
    private final Date expirationDate;

    public ExpirableProduct(String name, double price, int quantity, Date expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

    public Date getExpirationDate() { return expirationDate;  }

    public boolean isExpired() {
        return expirationDate != null && expirationDate.before(new Date());
    }

}
