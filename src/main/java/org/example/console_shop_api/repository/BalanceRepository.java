package org.example.console_shop_api.repository;

import org.example.console_shop_api.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<Balance, Long> {
}
