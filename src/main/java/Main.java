import org.fawry.ecommerce.abstracts.CheckoutValidation;
import org.fawry.ecommerce.abstracts.Product;
import org.fawry.ecommerce.abstracts.ProductType;
import org.fawry.ecommerce.builders.ExpirableProductBuilder;
import org.fawry.ecommerce.builders.ExpirableShippableProductBuilder;
import org.fawry.ecommerce.builders.GenericProductBuilder;
import org.fawry.ecommerce.builders.ShippableProductBuilder;
import org.fawry.ecommerce.factories.ProductFactory;
import org.fawry.ecommerce.handlers.BalanceHandler;
import org.fawry.ecommerce.handlers.EmptyCartHandler;
import org.fawry.ecommerce.handlers.ExpiryHandler;
import org.fawry.ecommerce.models.Customer;
import org.fawry.ecommerce.services.CheckoutService;
import org.fawry.ecommerce.services.ShippingService;


import java.util.Calendar;


public class Main {
    public static void main(String[] args) {
        ProductFactory.registerBuilder(ProductType.EXPIRABLE, new ExpirableProductBuilder());
        ProductFactory.registerBuilder(ProductType.SHIPPABLE, new ShippableProductBuilder());
        ProductFactory.registerBuilder(ProductType.EXPIRABLE_SHIPPABLE, new ExpirableShippableProductBuilder());
        ProductFactory.registerBuilder(ProductType.GENERIC, new GenericProductBuilder());

        Calendar cheeseCal = Calendar.getInstance();
        cheeseCal.add(Calendar.DAY_OF_MONTH, 15);

        Product cheese = ProductFactory.create(
                ProductType.EXPIRABLE_SHIPPABLE,
                "Cheeeeese",
                50.69,
                15,
                cheeseCal.getTime(),
                15,
                0.6
                );
        Product TV = ProductFactory.create(
                ProductType.SHIPPABLE,
                "Samsung 69' TV",
                3000,
                5,
                 null,
                25,
                1.2
        );
        Product giftCard = ProductFactory.create(
                ProductType.EXPIRABLE,
                "Amazon Gift Card",
                10,
                15,
                null,
                15,
                0
        );


        Customer customer = new Customer("Mohamed", 9000);
        customer.getCart().addItem(cheese, 1);
        customer.getCart().addItem(TV, 1);
        customer.getCart().addItem(giftCard, 2);


        CheckoutValidation handler = new EmptyCartHandler();
        handler.setnext(new ExpiryHandler()).setnext(new BalanceHandler());


        ShippingService shippingService = new ShippingService();
        CheckoutService checkout = new CheckoutService(customer, handler, shippingService);
        checkout.checkout();

    }
}