package ci.ayiyikoh.repository;

import ci.ayiyikoh.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    Customer findByPhoneNumber();
}
