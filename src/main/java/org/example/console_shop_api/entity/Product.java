package org.example.console_shop_api.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private BigDecimal price;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name = "category_id")
    private Category category;

    @Getter
    @Setter
    private int quantity;
}
