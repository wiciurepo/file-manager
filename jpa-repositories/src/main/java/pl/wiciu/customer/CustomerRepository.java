package pl.wiciu.customer;

import org.springframework.data.repository.CrudRepository;
import pl.wiciu.customer.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
