package org.example.console_shop_api.dto;

public class OrderItemRequest {
    private Long productId;
    private int quantity;

    public Long getProductId() {return productId; }

    public int getQuantity() {return quantity; }

    public void setProductId(Long productId) {this.productId = productId; }

    public void setQuantity(int quantity) {this.quantity = quantity; }

}
