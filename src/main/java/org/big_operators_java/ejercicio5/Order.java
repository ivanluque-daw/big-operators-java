package org.big_operators_java.ejercicio5;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Order {
    private String number;
    private Date ordered;
    private Date shipped;
    private Address shipTo;
    private OrderStatus status;
    private BigDecimal total;
    private List<LineItem> lineItems;

    public void addLineItem(LineItem item) {
        lineItems.add(item);
        total = total.add(item.getPrice().multiply(new BigDecimal(item.getQuantity())));
    }

    public Order(String number, Address shipTo) {
        this.number = number;
        this.shipTo = shipTo;
        this.ordered = new Date();
        this.status = OrderStatus.New;
        this.total = BigDecimal.ZERO;
        this.lineItems = new ArrayList<>();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getOrdered() {
        return ordered;
    }

    public void setOrdered(Date ordered) {
        this.ordered = ordered;
    }

    public Date getShipped() {
        return shipped;
    }

    public void setShipped(Date shipped) {
        this.shipped = shipped;
    }

    public Address getShipTo() {
        return shipTo;
    }

    public void setShipTo(Address shipTo) {
        this.shipTo = shipTo;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }
}

enum OrderStatus {
    New, Hold, Shipped, Delivered, Closed
}