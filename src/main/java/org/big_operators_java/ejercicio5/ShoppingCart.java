package org.big_operators_java.ejercicio5;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private Date created;
    private List<LineItem> lineItems;

    public void addLineItem(LineItem item) {
        lineItems.add(item);
    }

    public ShoppingCart() {
        this.created = new Date();
        this.lineItems = new ArrayList<>();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }
}
