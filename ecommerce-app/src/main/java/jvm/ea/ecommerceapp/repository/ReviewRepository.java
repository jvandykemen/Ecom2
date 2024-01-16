package jvm.ea.ecommerceapp.repository;

import jvm.ea.ecommerceapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
