package wecofa.frame.member.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wecofa.frame.member.customer.entity.Customer;

import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    public Optional<Customer> findCustomerByCusId(String cusId);
}
