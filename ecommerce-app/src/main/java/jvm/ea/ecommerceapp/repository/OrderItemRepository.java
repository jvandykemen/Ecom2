package jvm.ea.ecommerceapp.repository;


import jvm.ea.ecommerceapp.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
