package jvm.ea.ecommerceapp.service;

import jvm.ea.ecommerceapp.model.Order;
import jvm.ea.ecommerceapp.model.OrderItem;
import jvm.ea.ecommerceapp.model.Product;
import jvm.ea.ecommerceapp.model.User;
import jvm.ea.ecommerceapp.repository.OrderItemRepository;
import jvm.ea.ecommerceapp.repository.OrderRepository;
import jvm.ea.ecommerceapp.repository.ProductRepository;
import jvm.ea.ecommerceapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;


    @Autowired
    public OrderService(OrderRepository orderRepository, ProductRepository proRepository, OrderItemRepository oir) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }
    public Order createOrder(Order order) {
        // Additional business logic if needed

        // Ensure that the associated user exists in the database
        User user = userRepository.findById(order.getOrderId()).orElse(null);

        if (user != null) {
            order.setUser(user);

            // Save the order to get the generated order ID
            Order savedOrder = orderRepository.save(order);

            // Ensure that the associated order items exist in the database
            List<OrderItem> orderItems = order.getOrderItems();
            for (OrderItem orderItem : orderItems) {
                orderItem.setOrder(savedOrder);

                // Save the order item
                orderItemRepository.save(orderItem);
            }

            // Return the saved order with associated order items
            return savedOrder;
        }

        return null; // User not found
    }
    public Order updateOrder(Long orderId, Order updatedOrder) {
        // Additional business logic if needed

        // Fetch the existing order from the database
        Order existingOrder = orderRepository.findById(orderId).orElse(null);

        if (existingOrder != null) {
            // Update order properties
            existingOrder.setOrderDate(updatedOrder.getOrderDate());
            // Update other properties as needed

            // Ensure that the associated user exists in the database
            User user = userRepository.findById(updatedOrder.getOrderId()).orElse(null);

            if (user != null) {
                // Set the associated user
                existingOrder.setUser(user);

                // Update the existing order items or add new ones
                List<OrderItem> updatedOrderItems = updatedOrder.getOrderItems();
                for (OrderItem updatedOrderItem : updatedOrderItems) {
                    // Check if the order item already exists in the database
                    OrderItem existingOrderItem = orderItemRepository

                        .findById(updatedOrderItem.getOrderItemId())
                        .orElse(null);
//                    Order a = orderRepository.findById(updatedOrder.getOrderId()).orElse(null);

                    if (existingOrderItem != null) {
                        // Update order item properties
                        existingOrderItem.setQuantity(updatedOrderItem.getQuantity());
//                        a.setTotalAmount(updatedOrder.getTotalAmount());
                        // Update other properties as needed

                        // Save the updated order item
                        orderItemRepository.save(existingOrderItem);
                    } else {
                        // Set the order for a new order item
                        updatedOrderItem.setOrder(existingOrder);

                        // Save the new order item
                        orderItemRepository.save(updatedOrderItem);
                    }
                }

                // Save the updated order
                return orderRepository.save(existingOrder);
            }
        }

        return null; // Order or User not found
    }
//           existingOrderItem.setTotalAmount(updatedOrderItem.getTotalAmount());
public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
