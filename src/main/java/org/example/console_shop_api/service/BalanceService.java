package org.example.console_shop_api.service;


import org.example.console_shop_api.entity.Balance;
import org.example.console_shop_api.entity.BalanceStatus;
import org.example.console_shop_api.entity.Customer;
import org.example.console_shop_api.repository.BalanceRepository;
import org.example.console_shop_api.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BalanceService {
    private final BalanceRepository balanceRepository;
    private final CustomerRepository customerRepository;

    public BalanceService(BalanceRepository balanceRepository, CustomerRepository customerRepository) {
        this.balanceRepository = balanceRepository;
        this.customerRepository = customerRepository;
    }

    public void deposit(Customer customer, BigDecimal amount, BalanceStatus type) {
        validateAmount(amount);

        Balance balance = new Balance();
        balance.setCustomer(customer);
        balance.setOperationSum(amount);
        balance.setStatus(type);

        customer.setBalance(customer.getBalance().add(amount));

        customerRepository.save(customer);
        balanceRepository.save(balance);
    }

    public void withdraw(Customer customer, BigDecimal amount, BalanceStatus type) {
        validateAmount(amount);

        if (amount.compareTo(customer.getBalance()) > 0) {
            throw new IllegalArgumentException("Customer has not enough money. ");
        } else {

            Balance balance = new Balance();
            balance.setCustomer(customer);
            balance.setOperationSum(amount.negate());
            balance.setStatus(type);

            customer.setBalance(customer.getBalance().subtract(amount));


            customerRepository.save(customer);
            balanceRepository.save(balance);
        }
    }

    private void validateAmount(BigDecimal amount) {
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero. ");
        }
    }
}

