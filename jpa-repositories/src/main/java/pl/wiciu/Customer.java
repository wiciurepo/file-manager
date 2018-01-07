package pl.wiciu;



import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        @Column(name = "id")
        private Long id;
        @Column(name = "firstName")
        private String firstName;
        @Column(name = "lastName")
        private String lastName;

        protected Customer() {}

        public Customer(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return String.format(
                    "Customer[id=%d, firstName='%s', lastName='%s']",
                    id, firstName, lastName);
        }

}
