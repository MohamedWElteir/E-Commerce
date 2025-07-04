package org.fawry.ecommerce.interfaces;

import java.util.Date;

public interface Expirable {
   Date getExpirationDate();
   boolean isExpired();
}
