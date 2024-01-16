package jvm.ea.ecommerceapp.repository;

import jvm.ea.ecommerceapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
