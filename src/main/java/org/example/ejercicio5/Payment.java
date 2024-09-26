package org.example.ejercicio5;

import java.math.BigDecimal;
import java.util.Date;

public class Payment {
    private String id;
    private Date paid;
    private BigDecimal total;
    private String details;
    private Order order;

    public Payment(String id, BigDecimal total, String details, Order order) {
        this.id = id;
        this.paid = new Date();
        this.total = total;
        this.details = details;
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPaid() {
        return paid;
    }

    public void setPaid(Date paid) {
        this.paid = paid;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
