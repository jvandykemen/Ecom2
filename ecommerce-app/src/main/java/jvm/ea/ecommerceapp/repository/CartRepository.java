package jvm.ea.ecommerceapp.repository;

import jvm.ea.ecommerceapp.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
