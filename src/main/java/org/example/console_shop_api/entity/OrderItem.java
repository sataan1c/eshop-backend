package org.example.console_shop_api.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Table(name = "order_items")
public class OrderItem {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @Getter
    @Setter
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name = "product_id")
    private Product product;

    @Getter
    @Setter
    private String productName;

    @Getter
    @Setter
    private int quantity;

    @Getter
    @Setter
    private BigDecimal price;
}
