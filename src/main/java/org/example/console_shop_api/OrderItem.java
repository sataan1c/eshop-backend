package org.example.console_shop_api;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String productName;
    private int quantity;
    private BigDecimal price;

    public Long getId() {return id; }

    public Order getOrder() {return order; }

    public Product getProduct() {return product; }

    public String getProductName() {return productName; }

    public int getQuantity() {return quantity; }

    public BigDecimal getPrice() {return price; }

    public void setOrder(Order order) {this.order = order; }

    public void setProduct(Product product) {this.product = product; }

    public void setProductName(String productName) {this.productName = productName; }

    public void setQuantity(int quantity) {this.quantity = quantity; }

    public void setPrice(BigDecimal price) {this.price = price; }





}
