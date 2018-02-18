package pl.wiciu.services.database;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.wiciu.customer.Customer;
import pl.wiciu.customer.CustomerRepository;

@Service
@Profile("prod")
public class ProdDataSender implements DataSender{

    @Value("${app.name}")
    private String appName;

    @Autowired
    CustomerRepository repository;

    @Override
    public boolean send() {
        System.out.println("Sending data to DB. Application name:" + appName);

        repository.save(new Customer("Michelle", "Dessler"));

        // fetch all customers
        Iterable<Customer> all = repository.findAll();

        // fetch an individual customer by ID
        Customer customer = repository.findOne(1L);
        repository.findByLastName("Dessler");

    return true;
    }
}
