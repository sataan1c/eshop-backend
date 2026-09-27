package org.example.console_shop_api.service;


import jakarta.transaction.Transactional;
import org.example.console_shop_api.dto.OrderItemRequest;
import org.example.console_shop_api.dto.OrderRequest;
import org.example.console_shop_api.entity.*;
import org.example.console_shop_api.repository.CustomerRepository;
import org.example.console_shop_api.repository.OrderRepository;
import org.example.console_shop_api.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final BalanceService balanceService;

    public OrderService(CustomerRepository customerRepository,
                        ProductRepository productRepository,
                        OrderRepository orderRepository,
                        BalanceService balanceService) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.balanceService = balanceService;
    }

    @Transactional
    public Order placeOrder(OrderRequest request) {
        BigDecimal total = BigDecimal.ZERO;
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Order order = new Order();
        order.setCustomer(customer);
        order.setStatus(OrderStatus.pending);

        List<OrderItemRequest> items = request.getItems();


        if (items == null || items.isEmpty()) {
            throw new RuntimeException("Order list is empty");
        }

        for (OrderItemRequest itemRequest : items) {
            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            if (itemRequest.getQuantity() <= 0) {
                throw new RuntimeException("Products quantity must be greater than 0");
            }

            total = total.add(product.getPrice().multiply(BigDecimal.valueOf(itemRequest.getQuantity())));

            if (product.getQuantity() >= itemRequest.getQuantity()) {
                OrderItem item = new OrderItem();
                item.setOrder(order);
                item.setProduct(product);
                item.setProductName(product.getName());
                item.setPrice(product.getPrice());
                item.setQuantity(itemRequest.getQuantity());

                order.getItems().add(item);

                product.setQuantity(product.getQuantity() - itemRequest.getQuantity());
                productRepository.save(product);

            } else {
                throw new RuntimeException("Number of products in order is greater than number of products in stock. ");
            }
        }

        balanceService.withdraw(customer, total, BalanceStatus.order_payment);

        return orderRepository.save(order);
    }
}
