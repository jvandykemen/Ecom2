package jvm.ea.ecommerceapp.repository;

import jvm.ea.ecommerceapp.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
}
