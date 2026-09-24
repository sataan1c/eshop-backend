package org.example.console_shop_api.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "categories")
public class Category {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Getter
    @Setter
    private String name;

    @JsonIgnore
    @Getter
    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
