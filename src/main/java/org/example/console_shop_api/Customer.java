package org.example.console_shop_api;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private BigDecimal balance;

    public Long getId() {return id; }

    public String getName() {return name; }

    public String getEmail() {return email; }

    public BigDecimal getBalance() {return balance; }

    public String setName(String name) {this.name = name; }

    public String setEmail(String email) {this.email = email; }

    public BigDecimal setBalance(BigDecimal balance) {this.balance = balance; }
}
