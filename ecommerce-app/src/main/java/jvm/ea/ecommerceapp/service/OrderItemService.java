package jvm.ea.ecommerceapp.service;

import jvm.ea.ecommerceapp.model.Order;
import jvm.ea.ecommerceapp.model.OrderItem;
import jvm.ea.ecommerceapp.model.Product;
import jvm.ea.ecommerceapp.repository.OrderItemRepository;
import jvm.ea.ecommerceapp.repository.OrderRepository;
import jvm.ea.ecommerceapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository, OrderRepository orderItemRepository2) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem getOrderItemById(Long orderItemId) {
        return orderItemRepository.findById(orderItemId).orElse(null);
    }
    public OrderItem createOrderItem(OrderItem orderItem) {
        Order order = orderRepository.findById(orderItem.getOrder().getOrderId()).orElse(null);
        Product product = productRepository.findById(orderItem.getProduct().getProductId()).orElse(null);

        if (order != null && product != null) {
            orderItem.setOrder(order);
            orderItem.setProduct(product);

            // Save the order item
            return orderItemRepository.save(orderItem);
        }

        return null; // Order or Product not found
    }


    public OrderItem updateOrderItem(Long orderItemId, OrderItem updatedOrderItem) {
        // Additional business logic if needed

        // Fetch the existing OrderItem from the database
        OrderItem existingOrderItem = orderItemRepository.findById(orderItemId).orElse(null);

        if (existingOrderItem != null) {
            // Update OrderItem properties
            existingOrderItem.setQuantity(updatedOrderItem.getQuantity());
            // Update other properties as needed

            // Ensure that the associated Order and Product exist in the database
            Order order = orderRepository.findById(updatedOrderItem.getOrder().getOrderId()).orElse(null);
            Product product = productRepository.findById(updatedOrderItem.getProduct().getProductId()).orElse(null);

            if (order != null && product != null) {
                // Set the associated Order and Product
                existingOrderItem.setOrder(order);
                existingOrderItem.setProduct(product);

                // Save the updated OrderItem
                return orderItemRepository.save(existingOrderItem);
            }
        }

        return null; // OrderItem, Order, or Product not found
    }
    public void deleteOrderItem(Long orderItemId) {
        orderItemRepository.deleteById(orderItemId);
    }
}

