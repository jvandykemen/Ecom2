package jvm.ea.ecommerceapp.repository;

import jvm.ea.ecommerceapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
