package org.example.console_shop_api;


import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Enumerated
    private OrderStatus status;

    private Instant createdAt;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();

    public Long getId() {return id; }

    public Customer getCustomer() {return customer; }

    public String getStatus() {return status; }

    public Instant getCreatedAt() {return createdAt; }

    public void setCustomer(Customer customer) {this.customer = customer; }

    public void setStatus(OrderStatus status) {this.status = status; }

    public void setCreatedAt(Instant createdAt) {this.createdAt = createdAt; }

    public List<OrderItem> getItems() {return items; }

    public void setItems(List<OrderItem> items) {this.items = items; }


}
