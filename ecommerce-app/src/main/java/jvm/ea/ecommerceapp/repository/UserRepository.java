package jvm.ea.ecommerceapp.repository;

import jvm.ea.ecommerceapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
