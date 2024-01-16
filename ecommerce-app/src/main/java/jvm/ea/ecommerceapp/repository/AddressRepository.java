package jvm.ea.ecommerceapp.repository;
import jvm.ea.ecommerceapp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Long> {
}
