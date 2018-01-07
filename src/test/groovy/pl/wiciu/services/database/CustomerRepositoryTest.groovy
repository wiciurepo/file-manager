package pl.wiciu.services.database

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.jdbc.core.JdbcTemplate
import pl.wiciu.CustomerRepository
import spock.lang.Specification

import javax.sql.DataSource

@DataJpaTest
class CustomerRepositoryTest extends Specification {

    @Autowired
    CustomerRepository repository

    @Autowired
    DataSource dataSource

    @Autowired
    JdbcTemplate jdbcTemplate

    def "FindByLastName"() {
    given:
    def connection = dataSource.getConnection("sa","")
    jdbcTemplate.execute("insert into customer (id, first_name, last_name) values (1, 'John', 'Doe')")

    when:
    def customer = repository.findByLastName("Doe")

    then:
    customer.size() == 1
    }


}
