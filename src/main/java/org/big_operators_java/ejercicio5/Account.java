package org.big_operators_java.ejercicio5;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String id;
    private Address billingAddress;
    private boolean isClosed;
    private Date open;
    private Date closed;
    private ShoppingCart shoppingCart;

    private List<Order> orders;
    private List<Payment> payments;

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public Account(String id, Address billingAddress) {
        this.id = id;
        this.billingAddress = billingAddress;
        this.isClosed = false;
        this.open = new Date();
        this.orders = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public Date getOpen() {
        return open;
    }

    public void setOpen(Date open) {
        this.open = open;
    }

    public Date getClosed() {
        return closed;
    }

    public void setClosed(Date closed) {
        this.closed = closed;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
