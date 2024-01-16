package jvm.ea.ecommerceapp.repository;

import jvm.ea.ecommerceapp.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
