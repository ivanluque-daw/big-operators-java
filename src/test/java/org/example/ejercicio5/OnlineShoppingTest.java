package org.example.ejercicio5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OnlineShoppingTest {
    private WebUser user1, user2;
    private Customer customer1, customer2;
    private Account account1, account2;
    private Product product1, product2, product3;
    private ShoppingCart cart1, cart2;

    @BeforeEach
    public void setUp() {
        user1 = new WebUser("user1", "user1");
        user2 = new WebUser("user2", "user2");

        customer1 = new Customer("1", new Address(), new Phone(), "customer1@onlineshopping.test");
        customer2 = new Customer("2", new Address(), new Phone(), "customer2@onlineshopping.test");

        user1.setCustomer(customer1);
        user2.setCustomer(customer2);

        account1 = new Account("1", new Address());
        account2 = new Account("2", new Address());

        customer1.setAccount(account1);
        customer2.setAccount(account2);

        product1 = new Product("1", "Movil", new Supplier());
        product2 = new Product("2", "Lapicero", new Supplier());
        product3 = new Product("3", "Friegasuelos", new Supplier());

        cart1 = new ShoppingCart();
        cart2 = new ShoppingCart();

        account1.setShoppingCart(cart1);
        account2.setShoppingCart(cart2);
    }

    @Test
    public void testCreateWebUsersCustomersAndAccounts() {
        assertNotNull(user1);
        assertNotNull(user2);
        assertNotNull(customer1);
        assertNotNull(customer2);
        assertNotNull(account1);
        assertNotNull(account2);

        assertEquals(customer1, user1.getCustomer());
        assertEquals(customer2, user2.getCustomer());
        assertEquals(account1, customer1.getAccount());
        assertEquals(account2, customer2.getAccount());
    }

    @Test
    public void testCreateProducts() {
        assertNotNull(product1);
        assertNotNull(product2);
        assertNotNull(product3);
    }

    @Test
    public void testAddProductsToShoppingCart() {
        cart1.addLineItem(new LineItem(1, new BigDecimal("999.99"), product1));
        cart2.addLineItem(new LineItem(4, new BigDecimal("2.45"), product2));
        cart2.addLineItem(new LineItem(2, new BigDecimal("8.00"), product3));

        assertEquals(1, cart1.getLineItems().size());
        assertEquals(2, cart2.getLineItems().size());

        assertEquals(product1, cart1.getLineItems().getFirst().getProduct());
        assertEquals(product2, cart2.getLineItems().get(0).getProduct());
        assertEquals(product3, cart2.getLineItems().get(1).getProduct());
    }

    @Test
    public void testCreateOrderAndPaymentWithShoppingCart() {
        cart1.addLineItem(new LineItem(1, new BigDecimal("999.99"), product1));
        cart1.addLineItem(new LineItem(4, new BigDecimal("2.45"), product2));

        Order order = new Order("1", new Address());
        for (LineItem item : cart1.getLineItems()) {
            order.addLineItem(item);
        }

        account1.addOrder(order);
        BigDecimal total = new BigDecimal("1009.79").setScale(2, RoundingMode.HALF_UP);

        assertEquals(total, order.getTotal());

        Payment payment = new Payment("1", order.getTotal(), "Paypal", order);
        account1.addPayment(payment);

        assertEquals(1, account1.getOrders().size());
        assertEquals(1, account1.getPayments().size());
        assertEquals(order, payment.getOrder());
    }
}
