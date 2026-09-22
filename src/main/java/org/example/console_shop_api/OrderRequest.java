package org.example.console_shop_api;

import java.util.List;

public class OrderRequest {
    private Long customerId;
    private List<OrderItemRequest> items;

    public Long getCustomerId() {return customerId; }

    public List<OrderItemRequest> getItems() {return items; }

    public void setCustomerId(Long customerId) {this.customerId = customerId; }

    public void setItems(List<OrderItemRequest> items) {this.items = items; }



}
