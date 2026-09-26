package org.example.console_shop_api.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.Instant;

@Table(name = "balance_transactions")
@Entity
@NoArgsConstructor
public class Balance {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @Column(nullable = false)
    @Getter
    @Setter
    private BigDecimal operationSum;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(nullable = false)
    @Getter
    @Setter
    private BalanceStatus status;

    @CreationTimestamp
    @Getter
    @Setter
    private Instant createdAt;
}
