package org.fawry.ecommerce.interfaces;

import java.time.LocalDate;

public interface Expirable {
   LocalDate getExpirationDate();
   boolean isExpired();
}
