# E-Commerce System in Java

A lightweight, extensible Java-based e-commerce system designed using clean object-oriented principles and several design patterns. Project is built as a task for Fawry's internship. The system supports product management, cart functionality, checkout validation, and shipping orchestration.

---

## Features

- Define products with name, price, and quantity
- Support for expirable products (e.g. Cheese, Biscuits)
- Shippable product handling with dynamic weight calculation
- Checkout summary including subtotal, shipping cost, and remaining balance
- Validation for:
    - Empty cart
    - Expired products
    - Insufficient user balance
    - Quantity exceeding stock
- Extensible with:
    - Builder Pattern for product creation
    - Factory Pattern with enum-based registration
    - Strategy and Interface Segregation for behavior separation
    - Chain of Responsibility for checkout validation

---

## Architecture Overview

```
Customer ─┬─> Cart ─┬─> CartItem ─> Product
          │         │
          │         └──> calculates subtotal, shipping
          │
          └─> CheckoutProcessor
                    │
                    ├──> CheckoutValidation (Chain)
                    └──> ShippingService
```

---

## Technologies Used

- Java 8+ (supports lambda and stream APIs)
- No third-party libraries required
- Clean console I/O with ANSI color formatting

---

## Product Types

| Type                 | Description                                |
|----------------------|--------------------------------------------|
| `EXPIRABLE`          | Has an expiration date                     |
| `SHIPPABLE`          | Has weight and needs to be shipped         |
| `EXPIRABLE_SHIPPABLE`| Both expirable and shippable               |
| `GENERIC`            | Regular item with no expiration/shipping   |

You can easily register new product types via the `ProductFactory`.

---

## Getting Started

### 1. Clone and Compile

```bash
git clone https://github.com/yourusername/ecommerce-system-java.git
cd ecommerce-system-java
javac ECommerceSystem.java
java ECommerceSystem
```

Requires JDK 8 or higher

---

## Sample Output

```
=== Checkout Summary ===
Subtotal: $3060.00
Shipping: $5.75
Total Paid: $3065.75
Remaining Balance: $934.25

Shipping the following items:
Item: [item], Weight: 15.0 kg, Shipping Fee: 0.6
Item: [item], Weight: 25.0 kg, Shipping Fee: 1.2
```

---

## Design Patterns Used

| Pattern                   | Purpose                                               |
|---------------------------|-------------------------------------------------------|
| Factory + Builder         | Create different product types with flexibility       |
| Strategy Interfaces       | `Shippable` and `Expirable` abstract behaviors        |
| Chain of Responsibility   | Modular validation pipeline for checkout              |
| Polymorphism via Enum     | Type-safe factory registration                        |

---

## Future Enhancements

- Persistent storage (JDBC or file-based)
- REST API layer using Spring Boot
- Unit testing with JUnit

---

## Author

Mohamed Wael  
Competitive programmer • .NET API enthusiast • 2× ECPC Qualifications Finalist

---