package org.example.console_shop_api.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    private OrderStatus status;


    @CreationTimestamp
    private Instant createdAt;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();

    public Long getId() {return id; }

    public Customer getCustomer() {return customer; }

    public OrderStatus getStatus() {return status; }

    public Instant getCreatedAt() {return createdAt; }

    public void setCustomer(Customer customer) {this.customer = customer; }

    public void setStatus(OrderStatus status) {this.status = status; }

    public void setCreatedAt(Instant createdAt) {this.createdAt = createdAt; }

    public List<OrderItem> getItems() {return items; }

    public void setItems(List<OrderItem> items) {this.items = items; }


}
