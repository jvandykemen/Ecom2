package jvm.ea.ecommerceapp.repository;

import jvm.ea.ecommerceapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
