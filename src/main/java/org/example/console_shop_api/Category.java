package org.example.console_shop_api;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Long getId() {return id; }

    public String getName() {return name; }

    public List<Product> getProducts() {return products; }

    public void setName(String name) {
        this.name = name;
    }

}
